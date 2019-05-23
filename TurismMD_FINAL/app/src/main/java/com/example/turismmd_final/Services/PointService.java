package com.example.turismmd_final.Services;

import com.example.turismmd_final.Model.Point;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PointService {
    @GET("api/poi/list")
    Call<List<Point>> getAllPoints();

    @GET("api/poi/{id}")
    Call<Point> getOnePoint(@Path("id")int id);

}
