package com.example.turismmd_final.Services;

import com.example.turismmd_final.Model.Point;
import com.example.turismmd_final.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @POST("api/user/register")
    Call<User> addUser(@Body User user);

    @POST("api/user/login/{username}/{password}")
    Call<User> getResponse(@Path("username")String username, @Path("password")String password);

}
