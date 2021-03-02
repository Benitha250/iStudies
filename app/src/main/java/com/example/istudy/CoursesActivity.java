package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.istudy.Adapter.CoursesAdapter;
import com.example.istudy.services.UserService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursesActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://istudy4.herokuapp.com/curriculum/1/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);
        Call<List<com.example.istudy.models.Courses>> call = userService.getPost();
        call.enqueue(new Callback<List<com.example.istudy.models.Courses>>() {
            @Override
            public void onResponse(Call<List<com.example.istudy.models.Courses>> call, Response<List<com.example.istudy.models.Courses>> response) {

                if (!response.isSuccessful()){
                    Toast.makeText(CoursesActivity.this, "Successfully retrieved!!!", Toast.LENGTH_LONG).show();
                    return;
                }

                List<com.example.istudy.models.Courses> coursesList = response.body();
                CoursesAdapter coursesAdapter = new CoursesAdapter(CoursesActivity.this, coursesList);
                recyclerView.setAdapter(coursesAdapter);
            }

            @Override
            public void onFailure(Call<List<com.example.istudy.models.Courses>> call, Throwable t) {

                Toast.makeText(CoursesActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}