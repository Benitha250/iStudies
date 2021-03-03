package com.example.istudy.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.istudy.R;
import com.github.barteksc.pdfviewer.PDFView;

public class p3math extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3math);

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("Math P3 Book.pdf")
                .enableSwipe(true)
                .load();
    }
}