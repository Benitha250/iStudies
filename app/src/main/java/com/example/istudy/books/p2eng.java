package com.example.istudy.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.istudy.R;
import com.github.barteksc.pdfviewer.PDFView;

public class p2eng extends AppCompatActivity {
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2eng);

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("ENG P2 PB.pdf")
                .enableSwipe(true)
                .load();
    }
}