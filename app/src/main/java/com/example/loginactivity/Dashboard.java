package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginactivity.model.DashBoard.DashExample;
import com.example.loginactivity.model.FooRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    String name;
    TextView allCompaint, paddingCompaint,completedCompaint,repeatingCompaint,totalno;
    CardView  allCompaintCard,pandingcomplaint,completedCard,reapetcomplaint,todaycomplaint;
    ImageView allCompaintImage;
    Button Logout,Submit;
     Spinner spinner;
     TextView textView;
    //TextView NAVigation
    TextView allCompaintnav,totalcomplaintnav,completedCompaintCardnav,reapet_complaint,today_complaint;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

               Logout=findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Dashboard.this);
                alertDialog.setTitle(" શું તમે ખરેખર લોગઆઉટ કરવા માંગો છો ?");

                alertDialog.setPositiveButton("હા", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       finishAffinity();
                        Intent i=new Intent(Dashboard.this,Login.class);
                        startActivity(i);
                    }
                });
                alertDialog.setNegativeButton("ના", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Dashboard.this, "તમે બહાર નથી નિકલ્યા.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                alertDialog.show();



            }
        });
        // DrawerLayout
        drawerLayout = findViewById(R.id.my_drawer_layout_dashboard);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        repeatingCompaint=findViewById(R.id.repeatingCompaint);

        // SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        name = sharedPref.getString("name", "");
        editor.apply();
        getcount(name);

        //Navigation Drower
        allCompaintnav = findViewById(R.id.allCompaintnav);
        allCompaintnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, FinalPage.class);
                startActivity(i);
            }
        });
        today_complaint = findViewById(R.id.today_complaint);
        today_complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, Today_complaint.class);
                startActivity(i);
            }
        });
        reapet_complaint = findViewById(R.id.reapet_complaint);
        reapet_complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, reapet_complaint.class);
                startActivity(i);
            }
        });
        totalcomplaintnav = findViewById(R.id.totalcomplaintnav);
        totalcomplaintnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, pandding_complaint.class);
                startActivity(i);
            }
        });
        completedCompaintCardnav=findViewById(R.id.completedCompaintCardnav);
        completedCompaintCardnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, completed_complaint.class);
                startActivity(i);
            }
        });



        totalno=findViewById(R.id.totalno);
        // allCompaint Click Event
        allCompaintImage = findViewById(R.id.allCompaintImage);
        allCompaint = findViewById(R.id.allCompaint);
        allCompaintCard = findViewById(R.id.allCompaintCard);
        allCompaintCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, FinalPage.class);
                startActivity(i);
            }
        });
        allCompaintImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, FinalPage.class);
                startActivity(i);
            }
        });
        allCompaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, FinalPage.class);
                startActivity(i);
            }
        });

        //Today
        todaycomplaint = findViewById(R.id.todaycomplait);
        todaycomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, Today_complaint.class);
                startActivity(i);
            }
        });
        //Pandingcomplaint
        pandingcomplaint= findViewById(R.id.pandingcomplaint);
        paddingCompaint = findViewById(R.id.paddingCompaint);
        pandingcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, pandding_complaint.class);
                startActivity(i);
            }
        });
        paddingCompaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, pandding_complaint.class);
                startActivity(i);
            }
        });

        reapetcomplaint=findViewById(R.id.reapetcomplaint);
        reapetcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, reapet_complaint.class);
                startActivity(i);
            }
        });
        //completedcomplaint
        completedCard= findViewById(R.id.completedCompaintCard);
        completedCompaint=findViewById(R.id.completedCompaint);
        completedCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, completed_complaint.class);
                startActivity(i);
            }
        });
        completedCompaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, completed_complaint.class);
                startActivity(i);
            }
        });

        //Spinner

        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.text_view);

        String[] options = {"Day In","Lunch Out", "Lunch In","Personal Out","Personal In", "Day Out"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = (String) parent.getItemAtPosition(position);
                textView.setText("You selected : " + selectedOption);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
 }
     @SuppressLint("NonConstantResourceId")

   public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       if (actionBarDrawerToggle.onOptionsItemSelected(item))
       {
                   return false;
       }
       return super.onOptionsItemSelected(item);

   }
    private void getcount(String name) {

        FooRequest fooRequest = new FooRequest(name);

        Call<DashExample> getlast_name = RetrofitAPI.getInstance().getMyApi().getcompaintDetails(name);

        getlast_name.enqueue(new Callback<DashExample>() {
            @Override
            public void onResponse(@NonNull Call<DashExample> call, @NonNull Response<DashExample> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        if (response.body() != null) {

                            repeatingCompaint.setText(String.valueOf(response.body().getRepeatingCompaint()));
                            allCompaint.setText(String.valueOf(response.body().getAllCompaint()));
                            paddingCompaint.setText(String.valueOf(response.body().getPaddingCompaint()));
                            completedCompaint.setText(String.valueOf(response.body().getCompletedCompaint()));
                            totalno.setText(String.valueOf(response.body().getNewComplaint()));
                        } else {
                            Toast.makeText(Dashboard.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

//                List<Datum> datumList=response.body();
            }

            @Override
            public void onFailure(@NonNull Call<DashExample> call, @NonNull Throwable t) {
                Toast.makeText(Dashboard.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }
        });
    }
      @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Dashboard.this);
        alertDialog.setTitle("શું તમે ખરેખર અરજી કરવા માંગો છો ?");
       ;

        alertDialog.setPositiveButton("હા", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Dashboard.this, "બહાર નિકલી ગયા", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(a);
              //  finishAffinity();
            }
        });
        alertDialog.setNegativeButton("ના", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Dashboard.this, "તમે બહાર નથી નિકલ્યા.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                          }
        });
        alertDialog.show();
        //Clicking the back button twice to exit an activity
    }
}