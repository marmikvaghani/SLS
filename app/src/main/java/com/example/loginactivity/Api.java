package com.example.loginactivity;

import com.example.loginactivity.model.DashBoard.DashExample;
import com.example.loginactivity.model.OPT_example.OtpExample;
import com.example.loginactivity.model.machinetype.MachineExample;
import com.example.loginactivity.model.total_com_ex.Example;
import com.example.loginactivity.model.FooRequest;
import com.example.loginactivity.model.completedComplaint.CompleteExample;
import com.example.loginactivity.model.engineer_padding_compaint.PaddingCompaintExample;
import com.example.loginactivity.model.reapet_example.RepetExample;
import com.example.loginactivity.model.today_comexample.TodayComplaintExample;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {

     String BASE_URL = "https://cms-sparrow.herokuapp.com/";

    // as we are making a post request to post a data
    // so we are annotating it with post
    // and along with that we are passing a parameter as users
    @POST("eng-apk-api/login")
    @FormUrlEncoded
    //on below line we are creating a method to post our data.
    Call<Datum> statusCode(@Field("name")String name,@Field("passWord")String passWord);

     @Headers({"Content-Type: application/json"})
     @PUT("eng-apk-api/engineer_complaint_data/{id}/")
     Call<Datum> groupList(@Path("id") String id, @Body FooRequest body);

     @POST("/add-complaint/find_engineer_name_complaint_data")
     @FormUrlEncoded
     Call<TodayComplaintExample> gettoday(@Field("engineerName") String engineerName);

     @POST("eng-apk-api/engineer_count")
     @FormUrlEncoded
     Call<DashExample> getcompaintDetails(@Field("name") String name);

     @POST("eng-apk-api/engineer_all_compaint")
     @FormUrlEncoded
     Call<Example> getCompalin(@Field("name") String name);

     @POST("eng-apk-api/engineer_padding_compaint")
     @FormUrlEncoded
     Call<PaddingCompaintExample> getpandding(@Field("name") String name);

     @POST("eng-apk-api/engineer_complete_compaint")
     @FormUrlEncoded
     Call<CompleteExample> getcomplited(@Field("name") String name);

     @POST("eng-apk-api/engineer_reapet_compaint")
     @FormUrlEncoded
     Call<RepetExample> getreapetcomplaint(@Field("name") String name);

     @POST("parts/machinetype_wise_all_parts")
     @FormUrlEncoded
     Call<MachineExample> getparts(@Field("machineType") String machineType);

     @POST("eng-apk-api/verify-otp")
     @FormUrlEncoded
     Call<OtpExample> getOtp( @Field("name") String name,@Field("passWord")String passWord,@Field("otp")String opt);
//     Call<OtpExample> getOtp( @Field("name") String name,@Field("passWord")String passWord,@Field("opt")int opt);
}