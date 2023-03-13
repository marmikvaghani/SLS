package com.example.loginactivity;

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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginactivity.model.OPT_example.OtpExample;

import java.util.Timer;
import java.util.TimerTask;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText userName, password;
    Button btnSubmit;
   /* TextView createAcc;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;*/
    ProgressBar ProgressBar;
    int counter=0;
    Button verify;
    TextView otp;
    TextView forgetpass;

    String userName1=null,pass1=null;
    int otp1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName =findViewById(R.id.login_username);
        password=findViewById(R.id.login_pass);
        ProgressBar = findViewById(R.id.progressBar);

        verify=findViewById(R.id.verify);
        otp=findViewById(R.id.otp);
        verify.setVisibility(View.GONE);
        otp.setVisibility(View.GONE);

        forgetpass=findViewById(R.id.forgetpass);
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Login.this);
                    alertDialog.setTitle("forget password");
                    alertDialog.setMessage("are you soure");

                    alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           /* Toast.makeText(Login.this, "forget password", Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(Intent.ACTION_MAIN);
                            a.addCategory(Intent.CATEGORY_HOME);
                            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(a);*/
                            // finishAffinity();
                        }
                    });
                    alertDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Login.this, "decline ", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                    //Clicking the back button twice to exit an activity
            }
        });


    btnSubmit = findViewById(R.id.btnSubmit_login);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                userName1 = userName.getText().toString();
                pass1 = password.getText().toString();


                if (userName1.equals("") || userName1==null){
                    Toast.makeText(Login.this,"નામ દાખલ કરો",Toast.LENGTH_LONG).show();
                }else if (pass1.equals("") || pass1==null){
                    Toast.makeText(Login.this,"પાસવર્ડ દાખલ કરો",Toast.LENGTH_LONG).show();
                }else{
                    ProgressBar.setVisibility(View.VISIBLE);

                    apiCall(userName1,pass1);
                }

            }

        });

       verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName1 = userName.getText().toString();
                pass1 = password.getText().toString();
                Log.d("otpppp",otp.getText().toString());
                Log.d("pass1",pass1);
                otp1 = Integer.parseInt(otp.getText().toString());

                Log.d("otp1", String.valueOf(otp1));

                    ProgressBar.setVisibility(View.VISIBLE);

//                    otpCall(userName1,pass1,otp1);
                    otpCall(userName1,pass1,otp.getText().toString());

            }
//            private void otpCall(String userName1, String pass1,int otp1) {
            private void otpCall(String userName1, String pass1,String  otp1) {

                Call<OtpExample> getlast_name= RetrofitAPI.getInstance().getMyApi().getOtp(userName1,pass1,otp1);
                getlast_name.enqueue(new Callback<OtpExample>() {
                    @Override
                    public void onResponse(@NonNull Call<OtpExample> call, @NonNull Response<OtpExample> response) {
                        Log.d("tresponse",response.body().toString());

                        if(response.body()!=null){
                            if (response.body().getStatusCode()!=null){

                                if (response.body().getStatusCode()==200){

                                      Intent intent = new Intent(Login.this,Dashboard.class);
                                      startActivity(intent);

                                        ProgressBar.setVisibility(View.VISIBLE);
                                        Timer timer=new Timer();
                                        TimerTask timerTask=new TimerTask() {
                                            @Override
                                            public void run() {
                                            counter++;
                                            ProgressBar.setProgress(counter);

                                            if (counter==100){
                                                timer.cancel();
                                            }
                                        }
                                    };
                                    timer.schedule(timerTask,100,100);
                                    ProgressBar.setVisibility(View.INVISIBLE);
                                }else{
                                    ProgressBar.setVisibility(View.INVISIBLE);
                                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Login.this);
                                    alertDialog.setTitle("ERROR");
                                    alertDialog.setMessage("OTP IS INVALID");

                                    alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                                    alertDialog.show();
                                }
                            }
                        }

                    }
                    @Override
                    public void onFailure(Call<OtpExample> call, Throwable t) {
                    }
                });
            }
        });
    }

    private void apiCall(String userName1, String pass1) {

        Call<Datum> getlast_name= RetrofitAPI.getInstance().getMyApi().statusCode(userName1,pass1);
        getlast_name.enqueue(new Callback<Datum>() {
            @Override
            public void onResponse(@NonNull Call<Datum> call, @NonNull Response<Datum> response) {
                Log.d("tresponse",response.body().toString());

                if(response.body()!=null){
                    if (response.body().getstatusCode()!=null){

                        if (response.body().getstatusCode().equals("200")){

                            SharedPreferences sharedPref = getSharedPreferences("Login", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("token", response.body().getToken());
                            editor.putString("name", userName1);
                            editor.apply();

//                                      Intent intent = new Intent(Login.this,OTP.class);
//                                      startActivity(intent);

                            btnSubmit.setVisibility(View.GONE);
                            forgetpass.setVisibility(View.GONE);
                            userName.setVisibility(View.GONE);
                            password.setVisibility(View.GONE);
                            Toast.makeText(Login.this,"OTP sent to your phone",Toast.LENGTH_SHORT).show();
                            verify.setVisibility(View.VISIBLE);
                            otp.setVisibility(View.VISIBLE);
                            ProgressBar.setVisibility(View.VISIBLE);
                            Timer timer=new Timer();
                            TimerTask timerTask=new TimerTask() {
                                @Override
                                public void run() {
                                    counter++;
                                    ProgressBar.setProgress(counter);

                                    if (counter==100){
                                        timer.cancel();
                                    }
                                }
                            };
                            timer.schedule(timerTask,100,100);
                            ProgressBar.setVisibility(View.INVISIBLE);
                        }else{
                            ProgressBar.setVisibility(View.INVISIBLE);
                            AlertDialog.Builder alertDialog=new AlertDialog.Builder(Login.this);
                            alertDialog.setTitle("ERROR");
                            alertDialog.setMessage("UserName or Password is Wrong.");

                            alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            alertDialog.show(); }
                    }
                }
//                List<Datum> datumList=response.body();
            }
            @Override
            public void onFailure(@NonNull Call<Datum> call, Throwable t) {
                Toast.makeText(Login.this, "તમારું ઇન્ટરનેટ શરૂ કરો", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Fetching the stored data from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        int a = sh.getInt("age", 0);

        // Setting the fetched data in the EditTexts
        userName.setText(s1);
        password.setText(String.valueOf(a));
    }

    // Store the data in the SharedPreference in the onPause() method
    // When the user closes the application onPause() will be called and data will be stored
    @Override
    protected void onPause() {
        super.onPause();
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", userName.getText().toString());
        myEdit.putInt(" ", Integer.parseInt(password.getText().toString()));
        myEdit.apply();
    }

}
 /*   createAcc=findViewById(R.id.createAcc);
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
                Toast.makeText(Login.this,"Enter Name Properliy ",Toast.LENGTH_SHORT).show();

            }
        });
*/

    /*  long  passCheck = Long.parseLong(password.getText().toString());
                firebaseDatabase = FirebaseDatabase.getInstance();
                reference =firebaseDatabase.getReference("User");
                Query query = reference.orderByChild("userName").equalTo(userName1);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            Long pass = snapshot.child(userName1).child("pass").getValue(Long.class);
                            if (pass.equals(passCheck)){
                                Intent intent = new Intent(Login.this,FinalPage.class);
                                intent.putExtra("userName",userName1);
                                startActivity(intent);
                                Toast.makeText(Login.this,"Login Successfully ",Toast.LENGTH_SHORT).show();
                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                Toast.makeText(Login.this,"Login Successfully ",Toast.LENGTH_SHORT).show();

                                builder.setCancelable(true);
                                builder.show();}

                        }else {
                            Toast.makeText(Login.this,"No data exists ",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });*/