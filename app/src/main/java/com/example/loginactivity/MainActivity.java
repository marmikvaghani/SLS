package com.example.loginactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button login, Reg;
    SharedPreferences shp;
    SharedPreferences.Editor shpEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (shp == null)
            shp = getSharedPreferences("myPreferences", MODE_PRIVATE);


        String userName = shp.getString("name", "");

        if (userName != null && !userName.equals("")) {
            Intent i = new Intent(MainActivity.this, FinalPage.class);
            startActivity(i);
            finish();

        } else
        {
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
            finish();
        }


        login =(Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

            }
        });
        Reg = findViewById(R.id.btnSignUp);
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        try {
            if (shp == null)
                shp = getSharedPreferences("Login", MODE_PRIVATE);

            shpEditor = shp.edit();
            shpEditor.putString("name", "");
            shpEditor.commit();

            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
            finish();

        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    }

}
