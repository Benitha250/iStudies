package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;



import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class NotesVideoActivity extends AppCompatActivity {
    @BindView(R.id.video)
    VideoView video;
    String video_url="https://res.cloudinary.com/ucynthy12/video/upload/v1615888579/Basic_Math_For_Kids__Addition_and_Subtraction_x91fex.mp4";
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_video);
        ButterKnife.bind(this);

        pd=new ProgressDialog(NotesVideoActivity.this);
        pd.setMessage("Loading Please wait");
        pd.show();
        //String video = Parcels.unwrap(getIntent().getParcelableExtra("video"));
        //String video_url = getIntent().getStringExtra("video");

        Uri uri=Uri.parse(video_url);
        video.setVideoURI(uri);
        video.setMediaController(new MediaController(this));
        video.requestFocus();
        video.start();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pd.dismiss();
            }
        });

    }

}
