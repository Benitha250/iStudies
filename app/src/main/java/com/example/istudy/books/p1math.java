package com.example.istudy.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.istudy.R;
import com.github.barteksc.pdfviewer.PDFView;

public class p1math extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1math);

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("Math P1 student book.pdf")
                .enableSwipe(true)
                .load();
    }
}