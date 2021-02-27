package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.istudy.models.LoginRequest;
import com.example.istudy.models.LoginResponse;
import com.example.istudy.storage.SharedPreferenceManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {
    @BindView(R.id.textViewwelcome)
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        LoginResponse user = SharedPreferenceManager.getInstance(this).getUser();
        welcome.setText("Welcome "+user.getToken());
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(!SharedPreferenceManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(ProfileActivity.this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }
}