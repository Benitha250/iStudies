package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.istudy.books.p1eng;
import com.example.istudy.books.p1math;
import com.example.istudy.books.p2eng;
import com.example.istudy.books.p2math;
import com.example.istudy.books.p3eng;
import com.example.istudy.books.p3math;
import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RaveUiManager;
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Books extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        ButterKnife.bind(this);

    }

    public void toeng1(View view) {
        Intent intent = new Intent(Books.this, p1eng.class);
        startActivity(intent);
    }

    public void toeng2(View view) {
        Intent intent = new Intent(Books.this, p2eng.class);
        startActivity(intent);
    }

    public void toeng3(View view) {
        Intent intent = new Intent(Books.this, p3eng.class);
        startActivity(intent);
    }

    public void tomath1(View view) {
        Intent intent = new Intent(Books.this, p1math.class);
        startActivity(intent);
    }

    public void tomath2(View view) {
        Intent intent = new Intent(Books.this, p2math.class);
        startActivity(intent);
    }

    public void tomath3(View view) {
        Intent intent = new Intent(Books.this, p3math.class);
        startActivity(intent);
    }


}