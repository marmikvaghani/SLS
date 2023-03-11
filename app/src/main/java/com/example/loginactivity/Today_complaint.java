package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginactivity.Adapter.todat_adapter;
import com.example.loginactivity.model.today_comexample.TodayComplaintExample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Today_complaint extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    todat_adapter pcRecycler;
    RecyclerView rv_list;
    String name, token;
    //Navigation
    TextView allCompaintnav,totalcomplaintnav,reapetcomplaint,completedCompaintCardnav;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_complaint);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences sharedPref = getSharedPreferences("Login", Context.MODE_PRIVATE);
        token = sharedPref.getString("token", "");
        name = sharedPref.getString("name", "");


        rv_list = findViewById(R.id.crv_list);
        getData(name);

        //Navigation Drower
        Button mainmenu;
        mainmenu = findViewById(R.id.mainmenu);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Today_complaint.this, Dashboard.class);
                startActivity(i);
            }
        });
        allCompaintnav = findViewById(R.id.allCompaintnav);
        allCompaintnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Today_complaint.this, FinalPage.class);
                startActivity(i);
            }
        });
        totalcomplaintnav = findViewById(R.id.totalcomplaintnav);
        totalcomplaintnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Today_complaint.this, pandding_complaint.class);
                startActivity(i);
            }
        });
        completedCompaintCardnav = findViewById(R.id.completedCompaintCardnav);
        completedCompaintCardnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Today_complaint.this, completed_complaint.class);
                startActivity(i);
            }
        });
        reapetcomplaint = findViewById(R.id.reapetcomplaint);
        reapetcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Today_complaint.this, reapet_complaint.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData(String name) {

        Call<TodayComplaintExample> getlast_name = RetrofitAPI.getInstance().getMyApi().gettoday(name);

        getlast_name.enqueue(new Callback<TodayComplaintExample>() {
            @Override
            public void onResponse(@NonNull Call<TodayComplaintExample> call, @NonNull Response<TodayComplaintExample> response) {



                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getData()));

                        if (response.body().getData().size()==0){

                        }else{
                            pcRecycler = new todat_adapter(Today_complaint.this,response.body().getData());
                            rv_list.setLayoutManager(new LinearLayoutManager(Today_complaint.this));
                            rv_list.setAdapter(pcRecycler);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<TodayComplaintExample> call, Throwable t) {
                Toast.makeText(Today_complaint.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
