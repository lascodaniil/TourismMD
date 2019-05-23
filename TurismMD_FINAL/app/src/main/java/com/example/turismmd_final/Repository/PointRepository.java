package com.example.turismmd_final.Repository;

import android.util.Log;

import com.example.turismmd_final.Model.Point;
import com.example.turismmd_final.Model.PointsServiceListener;
import com.example.turismmd_final.Services.PointService;
import com.example.turismmd_final.Services.RetrofitInstances;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PointRepository {

    PointService pointService = RetrofitInstances.getPointsService();
    public static List<Point> points;
    private PointsServiceListener pointsServiceListener;

    public PointRepository(PointsServiceListener listener) {

        this.pointsServiceListener = listener;
    }

    public void GetPoints() {
        Call<List<Point>> call = pointService.getAllPoints();
        call.enqueue(new Callback<List<Point>>() {
            @Override
            public void onResponse(Call<List<Point>> call, Response<List<Point>> response) {
               pointsServiceListener.onPonintsReceiver(response.body());
            }

            @Override
            public void onFailure(Call<List<Point>> call, Throwable t) {
                pointsServiceListener.onFailure();
            }
        });


    }
}
