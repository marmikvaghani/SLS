package com.example.loginactivity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FooRequest {

    @Expose
    @SerializedName("name")
    final String name;


            @SerializedName("startTime")
            @Expose
            final String startTime;
            @SerializedName("solution")
            @Expose
            final String solution;
            @SerializedName("endTime")
            @Expose
            final String endTime;

            @SerializedName("startAndEndTimeDuration")
            @Expose
            final String startAndEndTimeDuration;

            @SerializedName("latitude")
            @Expose
            final String latitude;

            @SerializedName("longitude")
            @Expose
            final String longitude;
            @SerializedName("address")
            @Expose
            final String address;

    /*@SerializedName("startComplaintLocation")
               @Expose
               final Object startComplaintLocation;
               @SerializedName("endComplaintLocation")
               @Expose
               final Object endComplaintLocation;
               @SerializedName("rating")
               @Expose
               final String rating;*/
//DashBoard
    public FooRequest(String sname) {
        this.name = sname;

        endTime = null;
       longitude=null;
        latitude=null;
     //   startComplaintLocation = null;
        startAndEndTimeDuration = null;
        startTime = null;
        solution = null;
        address = null;

    }
    //End
        public FooRequest(String solution, String endTime/*, float ratingg*/, String startAndEndTimeDuration,String latitude,String longitude,String address) {


            this.endTime = endTime;
            this.solution = solution;
            this.startAndEndTimeDuration=startAndEndTimeDuration;
            this.longitude=longitude;
            this.latitude=latitude;
            this.address=address;



            startTime = null;
          //  this.startComplaintLocation = null;
            // this.rating = String.valueOf(ratingg);
            name = null;
        }
        //Start
    public FooRequest(/*Object startComplaintLocation,*/ String starttime,String latitude,String longitude,String address) {

        /*this.startComplaintLocation=startComplaintLocation;*/

        this.longitude=longitude;
        this.latitude=latitude;
        this.startTime = starttime;
        this.address=address;




        startAndEndTimeDuration = null;
        endTime = null;
        solution = null;
        name = null;
    }
}