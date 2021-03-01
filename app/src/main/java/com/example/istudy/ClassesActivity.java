package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


import com.example.istudy.Adapter.ClassesAdapter;
import com.example.istudy.models.Classe;



public class ClassesActivity extends AppCompatActivity {
    private RecyclerView rvClasses;
    private ClassesAdapter classesAdapter;
    private List<Classe> mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        initViews();
        initmdataClasses();
        setClassesAdapter();
    }

    private void setClassesAdapter() {
        classesAdapter = new ClassesAdapter(this,mdata);
        rvClasses.setAdapter(classesAdapter);
    }

    private void initmdataClasses() {
        mdata = new ArrayList<>();
        mdata.add(new Classe(R.drawable.painting));
    }

    private void initViews() {
        rvClasses = findViewById(R.id.recycler_view_classes);
        rvClasses.setLayoutManager(new LinearLayoutManager(this));
        rvClasses.setHasFixedSize(true);
    }
}