package com.chlwhdtn.grouping.Retrofit;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.Location.Location;
import com.chlwhdtn.grouping.Data.LoginObject;
import com.chlwhdtn.grouping.Data.RegisterData;
import com.chlwhdtn.grouping.Data.Schedule;
import com.chlwhdtn.grouping.Data.UserRequestType;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GroupingService {

    // Auth

    @POST("grouping/auth/signin")
    Call<CommonResult> Login(
            @Body LoginObject loginObject
    );

    @POST("grouping/auth/signup")
    Call<CommonResult> Register(
            @Body RegisterData rd
    );

    @POST("grouping/auth/info")
    Call<CommonResult> getUserData(
            @Header("Authorization") String token,
            @Body UserRequestType type
    );

    @POST("grouping/group/create")
    Call<CommonResult> createGroup(
            @Header("Authorization") String token,
            @Body String title
    );

    // Group

    @GET("grouping/group/create")
    Call<CommonResult> getGroups(
            @Header("Authorization") String token
    );

    @GET("grouping/group/get_info")
    Call<CommonResult> getGroupInfo(
            @Header("Authorization") String token,
            @Query("code") String code
    );

    @POST("grouping/group/exit")
    Call<CommonResult> exitGroup(
            @Header("Authorization") String token,
            @Body String code
    );

    @POST("grouping/group/join")
    Call<CommonResult> joinGroup(
            @Header("Authorization") String token,
            @Body String code
    );

    // Schedule

    @POST("grouping/schedule/create")
    Call<CommonResult> addSchedule(
            @Header("Authorization") String token,
            @Body Schedule schedule
    );

    @GET("grouping/schedule/get")
    Call<CommonResult> getSchedules(
            @Header("Authorization") String token
    );

    @GET("grouping/schedule/get_date")
    Call<CommonResult> getSchedulesbyDate(
            @Header("Authorization") String token,
            @Query("date") String date
    );

}
