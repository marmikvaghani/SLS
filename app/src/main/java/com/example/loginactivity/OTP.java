package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginactivity.model.OPT_example.OtpExample;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class OTP extends AppCompatActivity {

    EditText otp_txt;
    EditText username,password;

    Button verify_opt;
    /* TextView createAcc;
     FirebaseDatabase firebaseDatabase;
     DatabaseReference reference;*/
   int counter=0;
     String otp_txt1=null,name=null, passWord=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
/*
        otp_txt=findViewById(R.id.otp_txt);



        verify_opt = findViewById(R.id.verify_opt);
        verify_opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                name = username.getText().toString();
//                passWord = password.getText().toString();
                otp_txt1 = otp_txt.getText().toString();


                if (otp_txt1.equals("") || otp_txt1==null){
                    Toast.makeText(OTP.this,"Enter OTP",Toast.LENGTH_LONG).show();
                }else{
                   apiCall(name,passWord,otp_txt1);
                }
            }
            private void apiCall(String name, String passWord, String otp) {

                Call<OtpExample> getlast_name= RetrofitAPI.getInstance().getMyApi().getOtp(name,passWord,otp);
                getlast_name.enqueue(new Callback<OtpExample>() {
                    @Override
                    public void onResponse(@NonNull Call<OtpExample> call, @NonNull Response<OtpExample> response) {
                        Log.d("tresponse222",response.body().toString());

                        if(response.body()!=null){
                            if (response.body().getstatusCode()!=null){

                                if (response.body().getstatusCode().equals("200")){
                                   Intent intent = new Intent(OTP.this,Dashboard.class);
                                    startActivity(intent);
                                    Toast.makeText(OTP.this,"એન્જિનિયર સફળતાપૂર્વક લૉગિન થઈ ગયો.",Toast.LENGTH_SHORT).show();

                                }else {

                                    Toast.makeText(OTP.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
//                List<Datum> datumList=response.body();
                    }

                    @Override
                    public void onFailure(Call<OtpExample> call, Throwable t) {
                        Toast.makeText(OTP.this, "Network error: ", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });*/
    }
}