package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.istudy.books.p1eng;
import com.example.istudy.books.p3eng;

public class Books extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
    }

    public void button1(View view) {
        Intent intent = new Intent(Books.this, p1eng.class);
        startActivity(intent);
    }
    public void button2(View view) {
        Intent intent = new Intent(Books.this, p3eng.class);
        startActivity(intent);
    }

    public void topayment(View view) {
        Intent intent = new Intent(Books.this, PaymentActivity.class);
        startActivity(intent);
    }
}