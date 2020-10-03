package com.chlwhdtn.grouping.Retrofit;

import com.chlwhdtn.grouping.Data.Location.Location;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface GroupingService {

    @POST("/auth/signin")
    Call<RequestBody> Login(
            @Field("id") String id,
            @Field("password") String password,
            @Field("deviceId") String deviceId
    );

    @POST("/auth/signup")
    Call<RequestBody> Register(
            @Field("id") String id,
            @Field("password") String password,
            @Field("checkPassword") String checkpassword,
            @Field("location") Location location,
            @Field("locationName") String locationName,
            @Field("username") String username,
            @Field("deviceId") String deviceId
    );

}
