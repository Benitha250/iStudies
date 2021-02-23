package com.example.istudy.services;

import com.example.istudy.models.LoginRequest;
import com.example.istudy.models.LoginResponse;
import com.example.istudy.models.RegisterRequest;
import com.example.istudy.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("login/")
    Call<LoginResponse> LoginUser(@Body LoginRequest loginRequest);

    @POST("register/")
    Call<RegisterResponse> RegisterUser(@Body RegisterRequest registerRequest);

}

