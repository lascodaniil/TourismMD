package com.example.turismmd_final;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.turismmd_final.Adapter.PostAdapter;
import com.example.turismmd_final.Fragmemts.AllPosts;
import com.example.turismmd_final.Fragmemts.Authentification;
import com.example.turismmd_final.Fragmemts.Login;
import com.example.turismmd_final.Fragmemts.StartFragment;
import com.example.turismmd_final.Model.Point;
import com.example.turismmd_final.Model.User;
import com.example.turismmd_final.Repository.PointRepository;
import com.example.turismmd_final.Services.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

   public static List<Point> points  ;
    DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    FragmentTransaction ft = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_menu);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container , new StartFragment());
        ft.commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int ID = menuItem.getItemId();


        if(ID == R.id.ALLDESTINATION){
            ft =null;

            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container , new AllPosts());
            ft.commit();


        }

        if(ID == R.id.START){
            ft =null;

            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container , new StartFragment());
            ft.commit();


        }


        if(ID == R.id.authentification){
            ft =null;

            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container , new Authentification());
            ft.commit();


        }


        if(ID == R.id.login_fragment){
            ft =null;
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container , new Login());
            ft.commit();






        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return  true;
    }


    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }





}
