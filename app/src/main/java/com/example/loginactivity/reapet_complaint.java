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

import com.example.loginactivity.Adapter.pandding_adapter;
import com.example.loginactivity.Adapter.reapet_adapter;
import com.example.loginactivity.model.engineer_padding_compaint.PaddingCompaintExample;
import com.example.loginactivity.model.reapet_example.RepetExample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class reapet_complaint extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    reapet_adapter recyclerAdapter;
    RecyclerView rv_list;

    String name, token;

    //Navigation
    TextView allCompaintnav,totalcomplaintnav,completedCompaintCardnav,today_complaint;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reapet_complaint);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back butlon to close drawer
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


        rv_list = findViewById(R.id.rv_list1);
        getData(name);

        //Navigation Drower
        Button mainmenu;
        mainmenu = findViewById(R.id.mainmenu);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(reapet_complaint.this, Dashboard.class);
                startActivity(i);
            }
        });
        allCompaintnav = findViewById(R.id.allCompaintnav);
        allCompaintnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(reapet_complaint.this, FinalPage.class);
                startActivity(i);
            }
        });
        today_complaint = findViewById(R.id.today_complaint);
        today_complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(reapet_complaint.this, Today_complaint.class);
                startActivity(i);
            }
        });
        totalcomplaintnav = findViewById(R.id.totalcomplaintnav);
        totalcomplaintnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(reapet_complaint.this, pandding_complaint.class);
                startActivity(i);
            }
        });
        completedCompaintCardnav=findViewById(R.id.completedCompaintCardnav);
        completedCompaintCardnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(reapet_complaint.this, completed_complaint.class);
                startActivity(i);
            }
        });

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return false;
        }
        return super.onOptionsItemSelected(item);

    }
    private void getData(String name) {

        Call<RepetExample> getlast_name = RetrofitAPI.getInstance().getMyApi().getreapetcomplaint(name);

        getlast_name.enqueue(new Callback<RepetExample>() {
            @Override
            public void onResponse(@NonNull Call<RepetExample> call, @NonNull Response<RepetExample> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getData()));

                        if (response.body().getData() != null) {

                            recyclerAdapter = new reapet_adapter(reapet_complaint.this,response.body().getData());
                            rv_list.setLayoutManager(new LinearLayoutManager(reapet_complaint.this));
                            rv_list.setAdapter(recyclerAdapter);

                        } else {
                            Toast.makeText(reapet_complaint.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


//                List<Datum> datumList=response.body();
            }

            @Override
            public void onFailure(@NonNull Call<RepetExample> call, @NonNull Throwable t) {
                Toast.makeText(reapet_complaint.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }
        });
    }

}