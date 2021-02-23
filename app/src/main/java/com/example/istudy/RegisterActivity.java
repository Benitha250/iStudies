package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.istudy.models.RegisterRequest;
import com.example.istudy.models.RegisterResponse;
import com.example.istudy.services.ApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register)
    Button register;
    @BindView(R.id.toLoginPage)
    Button toLoginPage;

    @BindView(R.id.email) EditText email;
    @BindView(R.id.username) EditText name;

    @BindView(R.id.password) EditText password;
    @BindView(R.id.confirmPassword) EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Password2 = confirmPassword.getText().toString();

                RegisterRequest registerRequest = new RegisterRequest( Name, Password, Password2, Email);


                registerUser(registerRequest);
            }
        });
        toLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void registerUser(RegisterRequest registerRequest) {
        Call<RegisterResponse> registerResponseCall= ApiClient.getService().RegisterUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    String message = "Successfully logged in";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();

                }else {
                    String message = "An error occured. Please try again";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_SHORT).show();

            }
        });

    }
}