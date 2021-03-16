package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.istudy.Adapter.CourseAdapter;
import com.example.istudy.models.Lesson;
import com.example.istudy.services.UserService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CourseActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView_lessons_course)
    RecyclerView recyclerView;
    @BindView(R.id.back)
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://istudy4.herokuapp.com/curriculum/1/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);
        Call<List<Lesson>> call = userService.getLesson();
        call.enqueue(new Callback<List<Lesson>>() {
            @Override
            public void onResponse(Call<List<Lesson>> call, Response<List<Lesson>> response) {

                if (!response.isSuccessful()){
                    Toast.makeText(CourseActivity.this, "Successfully retrieved!!!", Toast.LENGTH_LONG).show();
                    return;
                }

                List<Lesson> lessonList = response.body();
                CourseAdapter courseAdapter = new CourseAdapter(CourseActivity.this, lessonList);
                recyclerView.setAdapter(courseAdapter);

            }

            @Override
            public void onFailure(Call<List<Lesson>> call, Throwable t) {

                Toast.makeText(CourseActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(CourseActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}