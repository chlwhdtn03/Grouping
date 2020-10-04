package com.chlwhdtn.grouping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.Location.Location;
import com.chlwhdtn.grouping.Data.RegisterData;
import com.chlwhdtn.grouping.Retrofit.GroupingRetrofit;
import com.chlwhdtn.grouping.Retrofit.GroupingService;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText id, pw, pw2, name;
    Button regbtn;
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backbtn = findViewById(R.id.reg_back);
        regbtn = findViewById(R.id.reg_regBtn);

        id = findViewById(R.id.reg_id);
        pw = findViewById(R.id.reg_pw);
        pw2 = findViewById(R.id.reg_pw2);
        name = findViewById(R.id.reg_name);

        regbtn.setOnClickListener(view -> {
            GroupingService retrofit = GroupingRetrofit.getInstance(getBaseContext()).getGroupingService();
            Call<CommonResult> response = retrofit.Register(new RegisterData(id.getText().toString(),pw.getText().toString(),pw2.getText().toString(),"0", name.getText().toString(), "0",new Location("0","0")));

            response.enqueue(new Callback<CommonResult>() {
                @Override
                public void onResponse(Call<CommonResult> call, Response<CommonResult> res) {
                    CommonResult result = res.body();

                    if(result == null) {
                        try { result = new Gson().fromJson(res.errorBody().string(), CommonResult.class); }
                        catch (IOException e) { e.printStackTrace(); }
                    }

                    if(result.isSuccess())
                        finish();
                    else
                        Toast.makeText(getBaseContext(), result.getMessage(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<CommonResult> call, Throwable t) {

                }
            });
        });


        backbtn.setOnClickListener(view -> {
            finish();
        });
    }
}