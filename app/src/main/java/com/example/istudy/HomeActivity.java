package com.example.istudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import android.widget.Toast;

import com.example.istudy.storage.SharedPreferenceManager;

public class HomeActivity extends AppCompatActivity {

    private RelativeLayout homePage;
    SharedPreferenceManager sharedPreferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homePage = findViewById(R.id.homePage);
        sharedPreferenceManager = new SharedPreferenceManager(getApplicationContext());
        Toast.makeText(this,"Welcome"+sharedPreferenceManager.getUser().getUsername() ,Toast.LENGTH_SHORT).show();



    }
/*    @Override
    protected void onStart() {
        super.onStart();
        if(!SharedPreferenceManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }*/

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
                Intent intent = new Intent(this,ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.help:
                homePage.setBackgroundColor(Color.GREEN);
                break;
            case R.id.contact:
                homePage.setBackgroundColor(Color.GREEN);
                break;
            case R.id.logout:
                logoutUser();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private void logoutUser(){
        sharedPreferenceManager.logout();
        Intent intent = new Intent(this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        Toast.makeText(this,"Logged out",Toast.LENGTH_SHORT).show();
    }

    public void tobook(View view) {
        Intent intent = new Intent(HomeActivity.this, Books.class);
        startActivity(intent);
    }
    public void tolessons(View view) {
        Intent intent = new Intent(HomeActivity.this, ClassesActivity.class);
        startActivity(intent);
    }

    public void toCourse(View view) {
        Intent intent = new Intent(HomeActivity.this, LessonsActivity.class);
        startActivity(intent);
    }

    public void toGrade1(View view) {
        Intent intent = new Intent(HomeActivity.this, Grade1Activity.class);
        startActivity(intent);
    }

}