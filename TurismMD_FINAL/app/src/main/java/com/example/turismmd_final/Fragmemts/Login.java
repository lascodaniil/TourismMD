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
import android.widget.Toast;

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

import static android.support.constraint.Constraints.TAG;

public class Login extends Fragment {
    EditText login, password, email;
    public User user = new User();
    private static String BASE_URL = "https://api-tourism-md.herokuapp.com/";
    List<User> users = null;
    View rootView;
    private Button registerbtn;
    public UserService userService;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.login_fragment, container, false);
        login = rootView.findViewById(R.id.username_field);
        password = rootView.findViewById(R.id.password_field);
        email = rootView.findViewById(R.id.email_field);
        registerbtn = rootView.findViewById(R.id.register);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String login1 = login.getText().toString();
                String password1 = password.getText().toString();
                String email1 = email.getText().toString();

                user.setEmail(email1);
                user.setPassword(password1);
                user.setUserName(login1);

                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .build();

                userService = RetrofitInstances.Registration();
                userService.addUser(user).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(getActivity(), "Utilizator Inregistrat", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getActivity(), "Utilizator Inregistrat", Toast.LENGTH_LONG).show();
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


