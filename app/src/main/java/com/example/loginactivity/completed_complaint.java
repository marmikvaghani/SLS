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

import com.example.loginactivity.Adapter.completed_adapter;
import com.example.loginactivity.model.completedComplaint.CompleteExample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class completed_complaint extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    completed_adapter pcRecycler;
    RecyclerView rv_list;
    String name, token;
    //Navigation
    TextView allCompaintnav,totalcomplaintnav,reapetcomplaint,today_copmlaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_complaint);

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
                Intent i = new Intent(completed_complaint.this, Dashboard.class);
                startActivity(i);
            }
        });
        allCompaintnav = findViewById(R.id.allCompaintnav);
        allCompaintnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(completed_complaint.this, FinalPage.class);
                startActivity(i);
            }
        });
        today_copmlaint = findViewById(R.id.today_complaint);
        today_copmlaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(completed_complaint.this, Today_complaint.class);
                startActivity(i);
            }
        });
        totalcomplaintnav = findViewById(R.id.totalcomplaintnav);
        totalcomplaintnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(completed_complaint.this, pandding_complaint.class);
                startActivity(i);
            }
        });
        reapetcomplaint = findViewById(R.id.reapetcomplaint);
        reapetcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(completed_complaint.this, reapet_complaint.class);
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

        Call<CompleteExample> getlast_name = RetrofitAPI.getInstance().getMyApi().getcomplited(name);

        getlast_name.enqueue(new Callback<CompleteExample>() {
            @Override
            public void onResponse(@NonNull Call<CompleteExample> call, @NonNull Response<CompleteExample> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getData()));

                        if (response.body().getData().size()==0){

                        }else{
                            pcRecycler = new completed_adapter(completed_complaint.this, response.body().getData());
                            rv_list.setLayoutManager(new LinearLayoutManager(completed_complaint.this));
                            rv_list.setAdapter(pcRecycler);
                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<CompleteExample> call, Throwable t) {
                Toast.makeText(completed_complaint.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
