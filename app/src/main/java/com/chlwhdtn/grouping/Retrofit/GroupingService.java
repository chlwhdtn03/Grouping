package com.chlwhdtn.grouping.Retrofit;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.Location.Location;
import com.chlwhdtn.grouping.Data.LoginObject;
import com.chlwhdtn.grouping.Data.RegisterData;
import com.chlwhdtn.grouping.Data.UserRequestType;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface GroupingService {

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

}
