package com.example.istudy.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.istudy.R;
import com.example.istudy.models.LoginRequest;
import com.example.istudy.models.LoginResponse;
import com.example.istudy.models.User;

import butterknife.BindView;

public class SharedPreferenceManager {
    private static final String SHARED_PREFERENCE_NAME="my_shared_preff";
    private static SharedPreferenceManager minstances;
    private Context mCtx;
    public SharedPreferenceManager(Context mCtx){
        this.mCtx = mCtx;
    }

    public static synchronized  SharedPreferenceManager getInstance(Context mCtx){
        if(minstances ==null){
            minstances = new SharedPreferenceManager(mCtx);
        }
        return minstances;
    }
    /*
    public void saveUser (User user){
        SharedPreferences sharedPreferences= mCtx.getSharedPreferences();
    }*/
    public void saveUser (LoginResponse user){
        SharedPreferences sharedPreferences= mCtx.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id",user.getId());
        editor.putString("email",user.getEmail());
        editor.putString("name",user.getUsername());
        editor.putString("password",user.getPassword());

        editor.apply();

    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id",-1)!=-1;
    }
    public  LoginResponse getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE);
        LoginResponse user = new LoginResponse(
                sharedPreferences.getString("name",null),
                sharedPreferences.getString("password",null),
                sharedPreferences.getString("email",null),
                sharedPreferences.getInt("id",-1));
        return user;
    }
    public void clear(){
        SharedPreferences sharedPreferences= mCtx.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    public void logout(){
        SharedPreferences sharedPreferences= mCtx.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


}
