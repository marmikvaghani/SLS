package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginactivity.model.FooRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class allCompaint extends AppCompatActivity {
    TextView  cmp_id,createDate,upadateTime,machineno,machinetype,partyname,detail,showtime,solution,showsecond;
    ImageButton start,end;
    Button add_com;
    String diff;

    // on the stopwatch.
    private int seconds = 0;
    // Is the stopwatch running?
    private boolean running;
    private boolean wasRunning;
    String time,id;
    Date startTime;
    RatingBar ratingBar;//190
    Date endTime;
    EditText com_sol_details;

    FusedLocationProviderClient mFusedLocationClient;

    // private static final int REQUEST_LOCATION = 1;
    double latitudeadd = 22.6708;
    double longitudeadd = 71.5724;
    // Initializing other items
    // from layout file
    TextView latitudeTextView, longitTextView,textView;
    int PERMISSION_ID = 44;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcompaint);
        checkPermissions();
        requestPermissions();
        isLocationEnabled();
        requestNewLocationData();

        latitudeTextView = findViewById(R.id.latTextView);
        longitTextView = findViewById(R.id.lonTextView);
        textView=findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);

        add_com=findViewById(R.id.add_com);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        latitudeTextView.setVisibility(View.INVISIBLE);
        longitTextView.setVisibility(View.INVISIBLE);

        showsecond=(TextView)findViewById(R.id.show_second);
        showsecond.setVisibility(View.INVISIBLE);

        solution = findViewById(R.id.Solution);
        solution.setVisibility(View.INVISIBLE);

        ratingBar=(RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setEnabled(false);


        add_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(allCompaint.this,Add_parts.class);
                startActivity(i);
            }
        });

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        if (savedInstanceState != null) {

            // Get the previous state of the stopwatch
            // if the activity has been
            // destroyed and recreated.
            seconds
                    = savedInstanceState
                    .getInt("seconds");
            running
                    = savedInstanceState
                    .getBoolean("running");
            wasRunning
                    = savedInstanceState
                    .getBoolean("wasRunning");
        }
        runTimer();

        start= findViewById(R.id.start);
        end= findViewById(R.id.End);
        showtime=findViewById(R.id.show_time);
        com_sol_details= findViewById(R.id.com_sol_details);
        checkPermissions();
        requestPermissions();
        isLocationEnabled();
        getLastLocation();
        setAddress(latitudeadd, longitudeadd);
        requestNewLocationData();

            start.setOnClickListener(new View.OnClickListener() {
            private KeyEvent event;

            @SuppressLint({"SimpleDateFormat", "MissingPermission"})
            @Override
            public void onClick(View v) {

                checkPermissions();
                requestPermissions();
                isLocationEnabled();
                requestNewLocationData();
                getLastLocation();
                setAddress(latitudeadd, longitudeadd);

                requestNewLocationData();
                add_com.setVisibility(View.VISIBLE);
                latitudeTextView.setVisibility(View.VISIBLE);
                longitTextView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);

                com_sol_details.setEnabled(true);
                com_sol_details.setVisibility(View.VISIBLE);
                end.setVisibility(View.VISIBLE);
                startTime = Calendar.getInstance().getTime();
                Log.d("startTime", String.valueOf(startTime));
                Toast.makeText(allCompaint.this, "ફરિયાદ શરૂ થઈ", Toast.LENGTH_SHORT).show();
                start.setEnabled(false);

                Log.d("testtiem", parseDateToddMMyyyy(String.valueOf(startTime)));

              /*  SimpleDateFormat spf=new SimpleDateFormat("HH:mm:ss");
                Date newDate= null;
                try {
                    newDate = spf.parse(startTime.toString());
                    Log.d("newDate", String.valueOf(newDate));
                } catch (ParseException e) {

                    e.printStackTrace();
                }
                spf= new SimpleDateFormat("HH:mm:ss");
*/

                if (start.isClickable()) {
                    requestNewLocationData();
                    end.setEnabled(true);
                    ratingBar.setEnabled(true);
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(allCompaint.this, "My Notification");
                    builder.setContentTitle("ફરિયાદ શરૂ થઈ");

                    builder.setSmallIcon(R.drawable.sls);
                    builder.setAutoCancel(true);

                    showtime.setText(parseDateToddMMyyyy(String.valueOf(startTime)));

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(allCompaint.this);
                    managerCompat.notify(1, builder.build());
                    start.setVisibility(View.INVISIBLE);
                    startsubmitData( parseDateToddMMyyyy(String.valueOf(startTime)),latitudeTextView.getText().toString(),longitTextView.getText().toString(),textView.getText().toString());
                }
                else
                {
                    end.setEnabled(false);
                }
                if (time.equals("")|| time==null){
                    onClickStart(v);
                }else {
                    onClickReset(v);
                }
                onClickStart(v);

            }
        });
        end.setEnabled(false);
        requestPermissions();
        requestNewLocationData();
        checkPermissions();
        com_sol_details.setEnabled(false);
        isLocationEnabled();
        end.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "SimpleDateFormat", "MissingPermission"})
            @Override
            public void onClick(View v) {

                checkPermissions();
                requestPermissions();
                isLocationEnabled();
                onResume();
                requestNewLocationData();
                getLastLocation();
                setAddress(latitudeadd,longitudeadd);

                latitudeTextView.setVisibility(View.VISIBLE);
                longitTextView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);

               /* if (ratingBar.getRating() == 0.0){
                    Toast.makeText(complain_menu.this, "કૃપા કરીને પહેલા રેટિંગ આપો", Toast.LENGTH_LONG).show();

                }else*/
                if(textView.getText().toString().equals("")){
                    Toast.makeText(allCompaint.this, "કૃપા કરીને પહેલા", Toast.LENGTH_LONG).show();

                }else  if (com_sol_details.getText().toString().equals("")  ) {

                    Toast.makeText(allCompaint.this, "કૃપા કરીને પહેલા ફરિયાદ ઉમેરો", Toast.LENGTH_LONG).show();

                } else if (latitudeTextView.getText().toString().equals(" ")) {
                    Toast.makeText(allCompaint.this, "first enable location", Toast.LENGTH_LONG).show();

                } else if (longitTextView.getText().toString().equals(" ")) {
                    Toast.makeText(allCompaint.this, "first enable location", Toast.LENGTH_LONG).show();


                } else{
                    Toast.makeText(allCompaint.this ,"ફરિયાદ પુરી થઈ", Toast.LENGTH_SHORT).show();

                 /*     SimpleDateFormat spf=new SimpleDateFormat("HH:mm:ss");
               Date newDate= null;
               try {
                    newDate = spf.parse(startT
                    String());
                } catch (ParseException e) {
                    e.printStackTrace();
                }*/


                    endTime = Calendar.getInstance().getTime();
                    showtime.setText( parseDateToddMMyyyy(String.valueOf(startTime))+" To "+ parseDateToddMMyyyy(String.valueOf(endTime)));

                   // String r=String.valueOf(ratingBar.getRating());
                  //  Toast.makeText(getApplicationContext(), r, Toast.LENGTH_SHORT).show();

                    NotificationCompat.Builder builder=new NotificationCompat.Builder(allCompaint.this,"My Notification");
                    builder.setContentTitle("ફરિયાદ સમાપ્ત");
                    builder.setSmallIcon(R.drawable.sls);
                    builder.setAutoCancel(true);
                    NotificationManagerCompat managerCompat=NotificationManagerCompat.from(allCompaint.this);
                    managerCompat.notify(1,builder.build());

//https://stackoverflow.com/questions/42026431/how-can-i-open-activity-when-notification-click

                    Log.d("start time", parseDateToddMMyyyy(String.valueOf(startTime)));
                    Log.d("end time",parseDateToddMMyyyy(String.valueOf(endTime)));
                    long millis = endTime.getTime() - startTime.getTime();
                    int hours = (int) (millis / (1000 * 60 * 60));
                    int mins = (int) ((millis / (1000 * 60)) % 60);
                    int sec = (int)((millis / 1000) % 60);

                     diff = (hours + ":" + mins+":"+sec);

                    Log.d("diff",diff);
                    //  Toast.makeText(complain_menu.this, time, Toast.LENGTH_SHORT).show();
                    showsecond.setText(diff);

                    endsubmitData(com_sol_details.getText().toString(),parseDateToddMMyyyy(String.valueOf(endTime)),showsecond.getText().toString(),latitudeTextView.getText().toString(),longitTextView.getText().toString(),textView.getText().toString());

                    Log.d("textView111", String.valueOf(textView));
                    showsecond.setVisibility(View.VISIBLE);
                    end.setEnabled(false);
                    ratingBar.setEnabled(false);
                    com_sol_details.setEnabled(false);

                    solution.setVisibility(View.VISIBLE);
                    start.setVisibility(View.INVISIBLE);
                   // com_sol_details.setVisibility(View.INVISIBLE);
                    end.setVisibility(View.INVISIBLE);

                }
                //  onClickStop(v);
             //   Log.d("time",time);

            }
        });
        {

            String CmpId = getIntent().getStringExtra("CmpId");
            Log.d("CmpId", CmpId);
            cmp_id = findViewById(R.id.cmp_id);
            cmp_id.setText(CmpId);

            String createDateAt = getIntent().getStringExtra("createDateAt");
            Log.d("createDateAt", createDateAt);
            createDate = findViewById(R.id.createDate);
            createDate.setText(createDateAt);

            String upadateTimeAt = getIntent().getStringExtra("upadateTimeAt");
            Log.d("upadateTimeeAt", upadateTimeAt);
            upadateTime = findViewById(R.id.upadateTime);
            upadateTime.setText(upadateTimeAt);

            String machineNo = getIntent().getStringExtra("machineNo");
            Log.d("machineNo", machineNo);
            machineno = findViewById(R.id.machineno);
            machineno.setText(machineNo);

            String machineType = getIntent().getStringExtra("machineType");
            Log.d("machineType", machineType);
            machinetype = findViewById(R.id.machinetype);
            machinetype.setText(machineType);

            String Solution = getIntent().getStringExtra("solution");
            Log.d("Solution", Solution);
            solution = findViewById(R.id.Solution);
            solution.setText(Solution);

            String partyName = getIntent().getStringExtra("partyName");
            Log.d("partyName", partyName);
            partyname = findViewById(R.id.partyname);
            partyname.setText(partyName);

            String details = getIntent().getStringExtra("details");
            id = getIntent().getStringExtra("id");
            Log.d("details", details);
            Log.d("id", id);

            detail = findViewById(R.id.detail);
            detail.setText(details);

        }
    }

    private void startsubmitData( String starttime,String latitude,String longitude,String address){

        FooRequest fooRequest=new FooRequest(starttime,latitude,longitude,address);

        Call<Datum> getfirst_name = RetrofitAPI.getInstance().getMyApi().groupList(id,fooRequest);
        getfirst_name.enqueue(new Callback<Datum>() {
            @Override
            public void onResponse(@NonNull Call<Datum> call,@NonNull Response<Datum> response) {
                Log.d("response", String.valueOf(response));
            }

            @Override
            public void onFailure(@NonNull Call<Datum> call,@NonNull Throwable t) {

            }
        });
    }

    private void endsubmitData(String solution, String endTime, String startAndEndTimeDuration,String latitude,String longitude,String address) {

        FooRequest fooRequest=new FooRequest(solution,endTime,startAndEndTimeDuration,latitude,longitude,address/*ratingBar.getRating()*/);

        Call<Datum> getlast_name = RetrofitAPI.getInstance().getMyApi().groupList(id,fooRequest);
        getlast_name.enqueue(new Callback<Datum>() {
            @Override
            public void onResponse(@NonNull Call<Datum> call,@NonNull Response<Datum> response) {
                Log.d("response", String.valueOf(response));
            }

            @Override
            public void onFailure(@NonNull Call<Datum> call,@NonNull Throwable t) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(
            @NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }

    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    // If the activity is resumed,
    // start the stopwatch
    // again if it was running previously.

    // Start the stopwatch running
    // when the Start button is clicked.
    // Below method gets called
    // when the Start button is clicked.
    public void onClickStart(View view)
    {
        running = true;
    }

    // when the Stop button is clicked.
    public void onClickStop(View view)
    {
        running = false;
    }

    // Reset the stopwatch when
    // the Reset button is clicked.
    // Below method gets called
    // when the Reset button is clicked.
    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    public String parseDateToddMMyyyy(String time) {

        String inputPattern = "EEE MMM dd HH:mm:ss zzzz yyyy";
        String outputPattern = "HH:mm:ss";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    // Sets the NUmber of seconds on the timer.
    // The runTimer() method uses a Handler
    // to increment the seconds and
    // update the text view.
    private void runTimer()
    {

        // Get the text view.
       /* final TextView timeView
                = (TextView)findViewById(
                R.id.time_view);*/

        // Creates a new Handler
        final Handler handler
                = new Handler();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                // Format the seconds into hours, minutes,
                // and seconds.
                time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);


                // Set the text view text.
                //Toast.makeText(complain_menu.this, time, Toast.LENGTH_SHORT).show();

                // If running is true, increment the
                // seconds variable.
                if (running) {
                    seconds++;
                }

                // Post the code again
                // with a dela y of 1 second.
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (startTime!=null){
      //   Log.d("if", String.valueOf(startTime)) ;
            if (endTime!=null){
             //   Log.d("else if", String.valueOf(startTime)) ;

                super.onBackPressed();
            }
        }
        else {
         //   Log.d("else", String.valueOf(startTime)) ;

            super.onBackPressed();
        }
       // super.onBackPressed();
      //  onClickReset(v);

    }
  /*  @Override
    public boolean onKeyDown(int key_code, KeyEvent key_event) {
        if (endTime.toString().equals("")) {
            if (key_code == KeyEvent.KEYCODE_BACK) {
                super.onKeyDown(key_code, key_event);
                return true;
            }
        }
            return false;

    }*/


   /* public boolean onKeyDown(int keyCode,KeyEvent event){
       if(keyCode== KeyEvent.KEYCODE_BACK)
           Toast.makeText(getApplicationContext(), "back press",
                   Toast.LENGTH_SHORT).show();

       // Disable back button..............
       return false;
   }*/

    @SuppressLint("SetTextI18n")
    private void setAddress(double latitude, double longitude) {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {

            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            //   String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL


            // Set the address to a TextView or any other UI element
            textView.setText(address);/* + ", " + city + ", " + state + ", " + country + ", " + postalCode);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        // check if permissions are given
        if (checkPermissions()) {

            // check if location is enabled
            if (isLocationEnabled()) {

                // getting last
                // location from
                // FusedLocationClient
                // object
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
                            latitudeTextView.setText(location.getLatitude() + "");
                            longitTextView.setText(location.getLongitude() + "");

                            setAddress(location.getLatitude(),location.getLongitude());

                        }
                    }
                });
            } else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            // if permissions aren't available,
            // request for permissions
            requestPermissions();
        }
    }

    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {

        @SuppressLint("SetTextI18n")
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            latitudeTextView.setText(mLastLocation.getLatitude() + "");
            longitTextView.setText( mLastLocation.getLongitude() + "");

            longitudeadd = mLastLocation.getLongitude();
            latitudeadd = mLastLocation.getLatitude();

              setAddress(mLastLocation.getLatitude(),mLastLocation.getLongitude());
        }
    };

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
        // ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
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
                getLastLocation();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }
}