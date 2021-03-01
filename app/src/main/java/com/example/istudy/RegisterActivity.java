package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.istudy.models.RegisterRequest;
import com.example.istudy.models.RegisterResponse;
import com.example.istudy.services.ApiClient;
import com.google.common.collect.Range;
import com.hbb20.CountryCodePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register) Button register;
    @BindView(R.id.toLoginPage) Button toLoginPage;
    @BindView(R.id.email) EditText email;
    @BindView(R.id.spinner) Spinner spinner;
    @BindView(R.id.username) EditText name;
    @BindView(R.id.names) EditText names;
    //@BindView(R.id.phone) EditText phoneN;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.confirmPassword) EditText confirmPassword;


    AwesomeValidation awesomeValidation;
    private ProgressDialog mAuthProgressDialog;

    private CountryCodePicker ccpicker;
    private EditText carrierNumber;
    private ImageView imgCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        createAuthProgressDialog();

        ccpicker = findViewById(R.id.ccpicker);
        carrierNumber = findViewById(R.id.carrierNumber);
        imgCheck = findViewById(R.id.imageCheck);

        //Attach CarrierNumber editText to CCP.
        ccpicker.registerCarrierNumberEditText(carrierNumber);
        ccpicker.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {
                // your code
                if(isValidNumber){
                    imgCheck.setImageResource(R.drawable.ic_check_circle);
                }else{
                    imgCheck.setImageResource(R.drawable.ic_highlight_off);
                }
            }
        });
        carrierNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString().trim();
                if(input.length()>0){
                    imgCheck.setVisibility(View.VISIBLE);
                }else{
                    imgCheck.setVisibility(View.GONE);
                }
            }
        });

        //validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        // add validations
        awesomeValidation.addValidation(this,R.id.names, RegexTemplate.NOT_EMPTY,R.string.invalid_names);
        awesomeValidation.addValidation(this,R.id.username, RegexTemplate.NOT_EMPTY,R.string.invalid_username);
        awesomeValidation.addValidation(this,R.id.email, Patterns.EMAIL_ADDRESS,R.string.invalid_email);

        String regexPassword = ".{3,}";
        awesomeValidation.addValidation(this, R.id.password, regexPassword, R.string.week_passwor);
        awesomeValidation.addValidation(this, R.id.confirmPassword, R.id.password, R.string.invalid_confirm_password);




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate() ) {
                    String FullNames = names.getText().toString();
                    String Name = name.getText().toString();
                    String Email = email.getText().toString();
                    String Password = password.getText().toString();
                    String Password2 = confirmPassword.getText().toString();
                    String Role = spinner.getSelectedItem().toString();
                    String phone =ccpicker.getFullNumber();
                    Double number = Double.parseDouble(phone);

                    RegisterRequest registerRequest = new RegisterRequest(FullNames, Name, Email, Role, number, Password, Password2);

                    registerUser(registerRequest);
                }else{
                    String message = "Registration failed!";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_SHORT).show();
                }

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
    private void createAuthProgressDialog() {
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Please wait while we are checking......");
        mAuthProgressDialog.setCancelable(false);
    }
    public void registerUser(RegisterRequest registerRequest) {
        mAuthProgressDialog.show();
        Call<RegisterResponse> registerResponseCall= ApiClient.getService().RegisterUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                mAuthProgressDialog.dismiss();

                if(response.isSuccessful()){
                    String msg = "Success";
                    Toast.makeText(RegisterActivity.this,msg,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);

                }else {
                    String msg = "failed";
                    Toast.makeText(RegisterActivity.this,msg,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                mAuthProgressDialog.dismiss();
                String message = t.getLocalizedMessage();
                Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();

            }
        });

    }
}