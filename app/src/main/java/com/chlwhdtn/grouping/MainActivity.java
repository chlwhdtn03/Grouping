package com.chlwhdtn.grouping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.Location.Location;
import com.chlwhdtn.grouping.Data.LoginObject;
import com.chlwhdtn.grouping.Data.UserRequestType;
import com.chlwhdtn.grouping.Retrofit.GroupingRetrofit;
import com.chlwhdtn.grouping.Retrofit.GroupingService;
import com.chlwhdtn.grouping.Util.UserManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView menu;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadUserInfo();

        menu = findViewById(R.id.main_menu);
        toolbar = findViewById(R.id.main_toolbar);

        menu.setOnNavigationItemSelectedListener(item -> {
            changeFragment(item.getItemId());
            return true;
        });

        changeFragment(R.id.menu1);

    }

    private void LoadUserInfo() {
        GroupingService retrofit = GroupingRetrofit.getInstance(getBaseContext()).getGroupingService();
        Call<CommonResult> response = retrofit.getUserData("Bearer " + UserManager.getAccount(getBaseContext()).getAccessToken(), new UserRequestType(Arrays.asList("id","username","location")));

        response.enqueue(new Callback<CommonResult>() {
            @Override
            public void onResponse(Call<CommonResult> call, Response<CommonResult> res) {
                CommonResult result = res.body();

                if(result == null) {
                    try { result = new Gson().fromJson(res.errorBody().string(), CommonResult.class); }
                    catch (IOException e) { e.printStackTrace(); }
                }

                if(result.isSuccess()) {
                    UserManager.setMy(result.getData());
                } else {
                    UserManager.deleteAccount(MainActivity.this);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<CommonResult> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void changeFragment(int id) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        switch(id) {
            case R.id.menu1: // 홈
                toolbar.setTitle("Grouping");
                HomeFragment home = new HomeFragment();
                t.replace(R.id.main_frame, home).commitAllowingStateLoss();
                break;
            case R.id.menu2: // 캘린더
                toolbar.setTitle("캘린더");
                CalendarFragment calendar = new CalendarFragment();
                t.replace(R.id.main_frame, calendar).commitAllowingStateLoss();
                break;
            case R.id.menu3: // 프로필
                toolbar.setTitle("내정보");
                ProfileFragment profile = new ProfileFragment();
                t.replace(R.id.main_frame, profile).commitAllowingStateLoss();
                break;
        }

    }
}