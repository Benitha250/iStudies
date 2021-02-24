package com.example.istudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;

public class HomeActivity extends AppCompatActivity {

    private RelativeLayout homePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homePage = findViewById(R.id.homePage);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.help:
                homePage.setBackgroundColor(Color.GREEN);
                break;
            case R.id.contact:
                homePage.setBackgroundColor(Color.GREEN);
                break;
            case R.id.logout:
                homePage.setBackgroundColor(Color.GREEN);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}