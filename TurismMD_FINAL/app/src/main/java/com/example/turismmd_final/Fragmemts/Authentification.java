package com.example.turismmd_final.Fragmemts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.turismmd_final.Model.ErrorRespose;
import com.example.turismmd_final.Model.User;
import com.example.turismmd_final.R;
import com.example.turismmd_final.Services.RetrofitInstances;
import com.example.turismmd_final.Services.UserService;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Authentification extends Fragment {

    View rootView, header_view;
    EditText username_auth, password_auth;
    Button btnauth;
    TextView textView;


    private static String BASE_URL = "https://api-tourism-md.herokuapp.com/";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.authentification_fragment, container, false);
        header_view = inflater.inflate(R.layout.navigation_header, container, false);
        textView = header_view.findViewById(R.id.username_user);
        textView = getActivity().findViewById(R.id.username_user);

        username_auth = rootView.findViewById(R.id.username_auth);
        password_auth = rootView.findViewById(R.id.password_auth);
        btnauth = rootView.findViewById(R.id.button_auth);


        btnauth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username_auth_str = username_auth.getText().toString();
                String password_auth_str = password_auth.getText().toString();


                UserService userService = RetrofitInstances.Authentification();
                userService.getResponse(username_auth_str, password_auth_str).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        // DE VERIFICAT DACA RASPUNSUL ESTE 200 SI DE AFISAT CORECT
                        if (response.isSuccessful()) {
                            ErrorRespose error = response.body();
                            if (error.getCode().equals("404")) {
                                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                            }else {
                                textView.setText(username_auth_str);
                            }

                        }


                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }

                });
            }
        });

        return rootView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}

