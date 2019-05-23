package com.example.turismmd_final.Services;

import com.example.turismmd_final.Model.User;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class RetrofitInstances {

        private static Retrofit retrofit_Points = null;
        private static Retrofit retrofit_Point = null;
        private static Retrofit retrofit_user_registration = null;
        private static Retrofit getRetrofit_user_authentification = null;
        private static String BASE_URL = "https://api-tourism-md.herokuapp.com/";


        public static PointService getPointsService(){
            if(retrofit_Points == null){
                retrofit_Points = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            }
            return  retrofit_Points.create(PointService.class);
        }


        public static PointService getOnePoint(int id){
            if(retrofit_Point == null){
                retrofit_Point = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            }
            return  retrofit_Point.create(PointService.class);
        }


        public static UserService Registration(){
            if(retrofit_user_registration == null){
                retrofit_user_registration = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            }

            return  retrofit_user_registration.create(UserService.class);
        }



        public static UserService Authentification(){


            final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            final OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();
            if(retrofit_user_registration == null){
                retrofit_user_registration = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

            }

            return  retrofit_user_registration.create(UserService.class);
        }



    }
