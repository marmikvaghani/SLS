
package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginactivity.Adapter.Parts_adapter;
import com.example.loginactivity.Adapter.pandding_adapter;
import com.example.loginactivity.Adapter.todat_adapter;
import com.example.loginactivity.model.engineer_padding_compaint.PaddingCompaintExample;
import com.example.loginactivity.model.machinetype.MachineExample;
import com.example.loginactivity.model.today_comexample.TodayComplaintExample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_parts extends AppCompatActivity {

    Parts_adapter recyclerAdapter;
    RecyclerView rv_list;
    String name, token,machineType;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parts);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences sharedPref = getSharedPreferences("Login", Context.MODE_PRIVATE);
        token = sharedPref.getString("token", "");
        name = sharedPref.getString ("name", "");
        machineType = sharedPref.getString("machineType", "");


        rv_list = findViewById(R.id.rv_list1);
        getData(machineType);

    }
    private void getData(String machineType) {

        Call<MachineExample> getlast_name = RetrofitAPI.getInstance().getMyApi().getparts(machineType);

        getlast_name.enqueue(new Callback<MachineExample>() {
            @Override
            public void onResponse(@NonNull Call<MachineExample> call, @NonNull Response<MachineExample> response) {

                if (response.body() != null) {
                    if (response.body().getStatusCode() != null) {

                        Log.d("responsedata", String.valueOf(response.body().getData()));

                        if (response.body().getData() != null) {


                        } else {
                            recyclerAdapter = new Parts_adapter(Add_parts.this, response.body().getData());
                            rv_list.setLayoutManager(new LinearLayoutManager(Add_parts.this));
                            rv_list.setAdapter(recyclerAdapter);
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<MachineExample> call, @NonNull Throwable t) {
                Toast.makeText(Add_parts.this, "એક ભૂલ આવે છે", Toast.LENGTH_SHORT).show();
            }
        });
    }
}