package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

    @BindView(R.id.back)
    TextView back;

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

    public void back(View view) {
        Intent intent = new Intent(SubjectActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}