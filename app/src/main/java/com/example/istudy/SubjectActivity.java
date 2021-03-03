package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.istudy.Adapter.SubjectAdapter;
import com.example.istudy.models.Lesson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubjectActivity extends AppCompatActivity {

    // List<Lesson> lessons;
    @BindView(R.id.recycler_view_subject)
    RecyclerView recyclerView;
    private SubjectAdapter mAdapter;
    public List<Lesson> lessons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        ButterKnife.bind(this);
        //lessons = Parcels.unwrap(getIntent().getParcelableExtra("lessons"));
        //int startingPosition = getIntent().getIntExtra("position", 0);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Lesson> lessonList = lessons;
        SubjectAdapter subjectAdapter = new SubjectAdapter(SubjectActivity.this, lessonList);
        recyclerView.setAdapter(subjectAdapter);


    }
}