package com.example.turismmd_final;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Rating;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.turismmd_final.Model.Point;
import com.example.turismmd_final.Services.PointService;
import com.example.turismmd_final.Services.RetrofitInstances;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PointActivityDetails extends AppCompatActivity  {
    Point point;
    private static String BASE_URL = "https://api-tourism-md.herokuapp.com/";
    TextView Title,Rating,Description;
    ImageView img;
   public String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_details);
        Toolbar toolbar = findViewById(R.id.toolbar);


        Intent intent = getIntent();
        int temp = intent.getIntExtra("POINT_ID",0);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        PointService pointService = retrofit.create(PointService.class);
        Call<Point> call = pointService.getOnePoint(temp);

        call.enqueue(new Callback<Point>() {
            @Override
            public void onResponse(Call<Point> call, Response<Point> response) {
                if(!response.isSuccessful()){

                }

                point = response.body();
                Title = (TextView)findViewById(R.id.TitlePost);
                Rating =(TextView)findViewById(R.id.Review);
                Description =(TextView)findViewById(R.id.Description);
                img = (ImageView)findViewById(R.id.imagePost) ;
                image = point.getImage();


                Title.setText(point.getName());
                Rating.setText(point.getRating());
                Description.setText(point.getDescription());

                byte[] decodeString = Base64.decode(image, Base64.DEFAULT);
                Bitmap decoded = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);
                img.setImageBitmap(decoded);

            }

            @Override
            public void onFailure(Call<Point> call, Throwable t) {

            }
        });
    }





}
