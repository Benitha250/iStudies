package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.istudy.Adapter.LessonAdapter;
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

public class LessonsActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_lessons)
    RecyclerView recyclerView;
    private LessonAdapter mAdapter;
    public List<Lesson> lessons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Retrofit client = ApiClient.getRetrofit();
        //Retrofit client2 = UserService.getRetrofit();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://istudy4.herokuapp.com/curriculum/1/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);
        Call<List<Lesson>> call = userService.getLesson();
        call.enqueue(new Callback<List<Lesson>>() {
            @Override
            public void onResponse(Call<List<Lesson>> call, Response<List<Lesson>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(LessonsActivity.this, "Successfully retrieved!!!", Toast.LENGTH_LONG).show();
                    return;
                }

                List<Lesson> lessonList = response.body();
                LessonAdapter lessonAdapterr = new LessonAdapter(LessonsActivity.this, lessonList);
                recyclerView.setAdapter(lessonAdapterr);
            }

            @Override
            public void onFailure(Call<List<Lesson>> call, Throwable t) {

                Toast.makeText(LessonsActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showFailureMessage() {
        Toast.makeText(LessonsActivity.this, "Successfully retrieved!!!", Toast.LENGTH_LONG).show();
        return;
    }

    private void showUnsuccessfulMessage() {
        Toast.makeText(LessonsActivity.this, "Something went wrong!!!", Toast.LENGTH_LONG).show();
        return;

    }
}