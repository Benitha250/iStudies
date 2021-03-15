package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.istudy.Adapter.LessonAdapter;
import com.example.istudy.models.Lesson;

import org.parceler.Parcels;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView_lessons)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        ButterKnife.bind(this);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Lesson lesson = Parcels.unwrap(getIntent().getParcelableExtra("lesson"));
        List<Lesson> lessonList = Collections.singletonList(lesson);

        LessonAdapter lessonAdapter = new LessonAdapter(LessonActivity.this, lessonList);

        recyclerView.setAdapter(lessonAdapter);
    }
}