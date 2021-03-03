package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.istudy.books.p1eng;
import com.example.istudy.books.p3eng;
import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RaveUiManager;
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Books extends AppCompatActivity {

    @BindView(R.id.pay1)
    Button payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        ButterKnife.bind(this);

    }

    public void button1(View view) {
        Intent intent = new Intent(Books.this, p1eng.class);
        startActivity(intent);
    }
    public void button2(View view) {
        Intent intent = new Intent(Books.this, p3eng.class);
        startActivity(intent);
    }

}