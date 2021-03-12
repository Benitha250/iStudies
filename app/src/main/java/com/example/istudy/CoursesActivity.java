package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.istudy.Adapter.CoursesAdapter;
import com.example.istudy.books.p3eng;
import com.example.istudy.services.UserService;
import com.example.istudy.storage.SharedPreferenceManager;
import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RaveUiManager;
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants;

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
    @BindView(R.id.pay)
    Button pay;
    SharedPreferenceManager sharedPreferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ButterKnife.bind(this);

        pay.setOnClickListener(V->topayment());


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
        sharedPreferenceManager = new SharedPreferenceManager(getApplicationContext());

    }

    public void topayment() {
        new RaveUiManager(this).setAmount(10000)
                .setCurrency("RWF")
                .setfName(sharedPreferenceManager.getUser().getFull_name())
                .setEmail(sharedPreferenceManager.getUser().getEmail())
                .setNarration("Book")
                .setPublicKey("FLWPUBK_TEST-e7170a6b8eeb8037d0eb1d5561c86a65-X")
                .setEncryptionKey("FLWSECK_TESTeb09f8eb8d17")
                .setTxRef(System.currentTimeMillis()+"ref")
                .setPhoneNumber("+"+sharedPreferenceManager.getUser().getPhone_number(), true)
                .acceptAccountPayments(true)
                .acceptCardPayments(true)
                .acceptMpesaPayments(false)
                .acceptAchPayments(false)
                .acceptGHMobileMoneyPayments(false)
                .acceptUgMobileMoneyPayments(false)
                .acceptZmMobileMoneyPayments(false)
                .acceptRwfMobileMoneyPayments(true)
                .acceptSaBankPayments(false)
                .acceptUkPayments(false)
                .acceptBankTransferPayments(false)
                .acceptUssdPayments(false)
                .acceptBarterPayments(false)
                .acceptFrancMobileMoneyPayments(false)
                .allowSaveCardFeature(false)
                .onStagingEnv(false)
                .withTheme(R.style.MyCustomTheme)
                .initialize();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RaveConstants.RAVE_REQUEST_CODE && data != null) {
            String message = data.getStringExtra("response");
            if (resultCode == RavePayActivity.RESULT_SUCCESS) {
                Toast.makeText(CoursesActivity.this, "SUCCESS ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CoursesActivity.this, HomeActivity.class);
                startActivity(intent);
            }
            else if (resultCode == RavePayActivity.RESULT_ERROR) {
                Toast.makeText(CoursesActivity.this, "ERROR ", Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RavePayActivity.RESULT_CANCELLED) {
                Toast.makeText(CoursesActivity.this, "CANCELLED ", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}