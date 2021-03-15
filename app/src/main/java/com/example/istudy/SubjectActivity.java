package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.istudy.Adapter.SubjectAdapter;
import com.example.istudy.models.Lesson;
import com.example.istudy.models.Subject;

import org.parceler.Parcels;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubjectActivity extends AppCompatActivity {


    @BindView(R.id.recycler_view_subject)
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        ButterKnife.bind(this);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Subject subject = Parcels.unwrap(getIntent().getParcelableExtra("subject"));
        List<Subject> subjectsList = Collections.singletonList(subject);

        SubjectAdapter subjectAdapter = new SubjectAdapter(SubjectActivity.this, subjectsList);

        recyclerView.setAdapter(subjectAdapter);

    }
}