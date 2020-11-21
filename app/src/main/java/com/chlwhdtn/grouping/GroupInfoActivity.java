package com.chlwhdtn.grouping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.Group;
import com.chlwhdtn.grouping.Data.RequestExitGroup;
import com.chlwhdtn.grouping.Data.ResponseGroupInfo;
import com.chlwhdtn.grouping.Data.User;
import com.chlwhdtn.grouping.Retrofit.GroupingRetrofit;
import com.chlwhdtn.grouping.Retrofit.GroupingService;
import com.chlwhdtn.grouping.Util.MessageBox;
import com.chlwhdtn.grouping.Util.MessageType;
import com.chlwhdtn.grouping.Util.UserManager;
import com.chlwhdtn.grouping.adapter.CrewAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupInfoActivity extends AppCompatActivity {

    TextView tv_code, tv_name, tv_count;
    RecyclerView crewlist;

    Button exitGroup, addSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info);

        Intent intent = getIntent();

        tv_code = findViewById(R.id.groupinfo_code);
        tv_name = findViewById(R.id.groupinfo_name);
        tv_count = findViewById(R.id.groupinfo_crew_count);

        exitGroup = findViewById(R.id.groupinfo_out_btn);

        exitGroup.setOnClickListener(item -> {
            GroupingService retrofit = GroupingRetrofit.getInstance(getBaseContext()).getGroupingService();
            Call<CommonResult> response = retrofit.exitGroup("Bearer " + UserManager.getAccount(getBaseContext()).getAccessToken(), new RequestExitGroup(intent.getStringExtra("code")));

            response.enqueue(new Callback<CommonResult>() {
                @Override
                public void onResponse(Call<CommonResult> call, Response<CommonResult> response) {
                    CommonResult result = response.body();

                    if(result == null) {
                        try { result = new Gson().fromJson(response.errorBody().string(), CommonResult.class); }
                        catch (IOException e) { e.printStackTrace(); }
                    }
                    if(result.isSuccess()) {
                        finish();
                    } else {
                        MessageBox.show(item, result.getMessage()+"", MessageType.WARNING);
                    }
                }

                @Override
                public void onFailure(Call<CommonResult> call, Throwable t) {

                }
            });
        });

        addSchedule = findViewById(R.id.groupinfo_createDate_btn);
        addSchedule.setOnClickListener(item -> {
            Intent s_intent = new Intent(getBaseContext(), ScheduleCreateActivity.class);
            s_intent.putExtra("code", intent.getStringExtra("code"));
            startActivity(s_intent);
        });

        crewlist = findViewById(R.id.groupinfo_crewlist);

        tv_code.setText(intent.getStringExtra("code"));
        tv_name.setText(intent.getStringExtra("name"));
        tv_count.setText("그룹 인원 (" + intent.getStringArrayExtra("member").length + ")");

        GroupingService retrofit = GroupingRetrofit.getInstance(getBaseContext()).getGroupingService();
        Call<CommonResult> response = retrofit.getGroupInfo("Bearer " + UserManager.getAccount(getBaseContext()).getAccessToken(), intent.getStringExtra("code"));

        response.enqueue(new Callback<CommonResult>() {
            @Override
            public void onResponse(Call<CommonResult> call, Response<CommonResult> response) {
                CommonResult result = response.body();

                if(result == null) {
                    try { result = new Gson().fromJson(response.errorBody().string(), CommonResult.class); }
                    catch (IOException e) { e.printStackTrace(); }
                }

                if(result.isSuccess()) {
                    Gson gson = new Gson();
                    String temp = gson.toJson(result.getList());
                    System.out.println(temp);
                    ResponseGroupInfo info = gson.fromJson(temp, ResponseGroupInfo.class);
                    CrewAdapter adapter = new CrewAdapter(info.getMember());
                    crewlist.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<CommonResult> call, Throwable t) {

            }
        });

    }
}