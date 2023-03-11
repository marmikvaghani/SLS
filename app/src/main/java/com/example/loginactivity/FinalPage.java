package com.example.loginactivity;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginactivity.Adapter.RecyclerAdapter;
import com.example.loginactivity.model.total_com_ex.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalPage extends AppCompatActivity {


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    RecyclerAdapter recyclerAdapter;
    RecyclerView rv_list;

    AlertDialog.Builder builder;
    String name, token;

    int PERMISSION_ID = 44;

    //Navigation
    TextView allCompaintnav,totalcomplaintnav,completedCompaintCardnav,reapetcomplaint,today_complaint;
    Button mainmenu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);



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


        rv_list = findViewById(R.id.rv_list);
        getData(name);

        //Navigation Drower
          mainmenu = findViewById(R.id.mainmenu);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinalPage.this, Dashboard.class);
                startActivity(i);
            }
        });
        reapetcomplaint = findViewById(R.id.reapetcomplaint);
        reapetcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinalPage.this, reapet_complaint.class);
                startActivity(i);
            }
        });
        today_complaint = findViewById(R.id.today_complaint);
        today_complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinalPage.this, Today_complaint.class);
                startActivity(i);
            }
        });
        totalcomplaintnav = findViewById(R.id.totalcomplaintnav);
        totalcomplaintnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinalPage.this, pandding_complaint.class);
                startActivity(i);
            }
        });
        completedCompaintCardnav=findViewById(R.id.completedCompaintCardnav);
        completedCompaintCardnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinalPage.this, completed_complaint.class);
                startActivity(i);
            }
        });


    }

    private void getData(String engineerName) {

        Call<Example> getlast_name = RetrofitAPI.getInstance().getMyApi().getCompalin(engineerName);

        getlast_name.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call, @NonNull Response<Example> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getData()));

                        if (response.body().getData() != null) {
                            checkPermissions();
                            requestPermissions();
                            isLocationEnabled();

                            recyclerAdapter = new RecyclerAdapter(FinalPage.this, response.body().getData());
                            rv_list.setLayoutManager(new LinearLayoutManager(FinalPage.this));
                            rv_list.setAdapter(recyclerAdapter);

                        } else {
                            Toast.makeText(FinalPage.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


//                List<Datum> datumList=response.body();
            }

            @Override
            public void onFailure(@NonNull Call<Example> call, @NonNull Throwable t) {
                Toast.makeText(FinalPage.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
                    return false;
        }
        return super.onOptionsItemSelected(item);

    }

   /* public void onBackPressed() {

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        Toast.makeText(this, "બહાર નીકળ્યા", Toast.LENGTH_LONG).show();
    }*/
//Exit android app on back pressed
  /*  @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(FinalPage.this);
        alertDialog.setTitle("એપ્લિકેશનમાંથી બહાર નીકળો.");
        alertDialog.setMessage("શું તમે બહાર નીકળવા માંગો છો ?");

        alertDialog.setPositiveButton("હા", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FinalPage.this, "બહાર નિકલી ગયા", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(a);
               // finishAffinity();
            }
        });
        alertDialog.setNegativeButton("ના", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FinalPage.this, "તમે બહાર નથી નિકલ્યા.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        alertDialog.show();
        //Clicking the back button twice to exit an activity
    }*/
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
        // ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    // If everything is alright then
    @Override
    public void
    onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            }
        }}

}