package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.istudy.models.LoginRequest;
import com.example.istudy.models.LoginResponse;
import com.example.istudy.storage.SharedPreferenceManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.full_name)
    TextView full_name;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.role)
    TextView role;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.logout)
    TextView logout;
    SharedPreferenceManager sharedPreferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        //LoginResponse user = SharedPreferenceManager.getInstance(this).getUser();
       // welcome.setText("Welcome "+user.getToken());
        sharedPreferenceManager = new SharedPreferenceManager(getApplicationContext());

        full_name.setText(sharedPreferenceManager.getUser().getFull_name());
        username.setText(sharedPreferenceManager.getUser().getUsername());
        email.setText(sharedPreferenceManager.getUser().getEmail());
        role.setText(sharedPreferenceManager.getUser().getRole());
        phone.setText(sharedPreferenceManager.getUser().getPhone_number());

    }
    @Override
    protected void onStart() {
        super.onStart();
       /* if(!SharedPreferenceManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(ProfileActivity.this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }*/
    }
    private void logoutUser(){
        sharedPreferenceManager.logout();
        Intent intent = new Intent(this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        Toast.makeText(this,"Logged out",Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
        Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void logout(View view) {
        logoutUser();
    }
}