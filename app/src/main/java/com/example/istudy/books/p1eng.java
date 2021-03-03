package com.example.istudy.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.istudy.R;
import com.github.barteksc.pdfviewer.PDFView;

public class p1eng extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1eng);

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("English P1 SB.pdf")
                .enableSwipe(true)
                .load();
    }
}