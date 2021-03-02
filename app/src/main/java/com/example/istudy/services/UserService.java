package com.example.istudy.services;

import com.example.istudy.models.Courses;
import com.example.istudy.models.LoginRequest;
import com.example.istudy.models.LoginResponse;
import com.example.istudy.models.RegisterRequest;
import com.example.istudy.models.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {
    @POST("token/")
    Call<LoginResponse> LoginUser(@Body LoginRequest loginRequest);

    @POST("register/")
    Call<RegisterResponse> RegisterUser(@Body RegisterRequest registerRequest);

    @GET("courses/")
    Call<List<Courses>> getPost();
}

