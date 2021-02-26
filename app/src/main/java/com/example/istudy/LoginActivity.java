package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.istudy.models.LoginRequest;
import com.example.istudy.models.LoginResponse;
import com.example.istudy.services.ApiClient;
import com.example.istudy.storage.SharedPreferenceManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login)
    Button login;
    @BindView(R.id.toRegisterPage)
    Button toRegisterPage;

    @BindView(R.id.username) EditText name;
    @BindView(R.id.password) EditText password;
    AwesomeValidation awesomeValidation;
    private ProgressDialog mAuthProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        createAuthProgressDialog();

        //validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        // add validations
        awesomeValidation.addValidation(this,R.id.username, RegexTemplate.NOT_EMPTY,R.string.invalid_username);
        awesomeValidation.addValidation(this,R.id.password, ".{3,}",R.string.week_passwor);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate() ) {
                    String Name = name.getText().toString();
                    String Password = password.getText().toString();

                    LoginRequest loginRequest = new LoginRequest(Name,Password);
                    loginUser(loginRequest);
                }else{
                    String message = "Authentication failed";
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
                }

            }
        });
        toRegisterPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(SharedPreferenceManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }

    private void createAuthProgressDialog() {
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Please wait while we are checking......");
        mAuthProgressDialog.setCancelable(false);
    }
    public void loginUser(LoginRequest loginRequest){
        mAuthProgressDialog.show();
        Call<LoginResponse> loginResponseCall = ApiClient.getService().LoginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                mAuthProgressDialog.dismiss();
                LoginResponse loginResponse = response.body();

                if(response.isSuccessful()){

                    SharedPreferenceManager.getInstance(LoginActivity.this).saveUser(loginResponse);
                    String message = "Successfully logged in";
                  
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class).putExtra("data",loginResponse);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                    /*
                     if(result.equalsIgnoreCase("Login")){
                        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginActivity.this,"Email or Password mismatched",Toast.LENGTH_SHORT).show();
                    }
                    * */



                }else{
                    String message = "Name or Password mismatched. Please, check and try again";
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();

            }
        });

    }
}