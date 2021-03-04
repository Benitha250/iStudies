package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.istudy.Adapter.Grade1Adapter;
import com.example.istudy.models.Grade1;

import java.util.ArrayList;
import java.util.List;
public class Grade1Activity extends AppCompatActivity {

    private RecyclerView rvClasses;
    private Grade1Adapter grade1Adapter;
    private List<Grade1> mdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade1);
        initViews();
        initmdataClasses();
        setClassesAdapter();
    }
    private void setClassesAdapter() {
        grade1Adapter = new Grade1Adapter(this,mdata);
        rvClasses.setAdapter(grade1Adapter);
    }
    private void initmdataClasses() {
        mdata = new ArrayList<>();
        mdata.add(new Grade1(R.drawable.crayons));
    }
    private void initViews() {
        rvClasses = findViewById(R.id.recycler_view_grade1);
        rvClasses.setLayoutManager(new LinearLayoutManager(this));
        rvClasses.setHasFixedSize(true);
    }
}