package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class NotesContentActivity extends AppCompatActivity {

    private  static final String TAG = "Description";
    private Context context;
    private WebView webView;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_content);

        context =  NotesContentActivity.this;
        webView = findViewById(R.id.webview);
        extras = getIntent().getExtras();
        if(extras!=null){
            String data = extras.getString("titles");
            Log.d(TAG,"onCreate: the coming data is"+data);
            String url = "file:///android_asset/"+data+".html";
            webView.loadUrl(url);
            WebSettings webSettings =webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);


            getSupportActionBar().setTitle(data.replace("",""));
            // getActionBar()..setTitle(data.replace("",""));
        }
    }
}