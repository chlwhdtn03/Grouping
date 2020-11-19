package com.chlwhdtn.grouping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.Group;
import com.chlwhdtn.grouping.Data.RequestJoinGroup;
import com.chlwhdtn.grouping.Retrofit.GroupingRetrofit;
import com.chlwhdtn.grouping.Retrofit.GroupingService;
import com.chlwhdtn.grouping.Util.UserManager;
import com.chlwhdtn.grouping.adapter.GroupAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView group_recyclerview, schedule_recylcerview;
    TextView home_more_group, schedule_create;

    GroupAdapter adapter = new GroupAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        home_more_group = v.findViewById(R.id.home_more_group);
        schedule_create = v.findViewById(R.id.home_more_schedule);
        group_recyclerview = v.findViewById(R.id.home_grouplist);

        group_recyclerview.setAdapter(adapter);

        LoadGroup();

        home_more_group.setOnClickListener(item -> {
            startActivity(new Intent(v.getContext(), CreateGroupActivity.class));
        });

        schedule_create.setOnClickListener(item -> {
            startActivity(new Intent(v.getContext(), ScheduleCreateActivity.class)); // 지우기!! 테스트용
        });

        return v;
    }

    private void LoadGroup() {
        GroupingService retrofit = GroupingRetrofit.getInstance(getContext()).getGroupingService();
        Call<CommonResult> response = retrofit.getGroups("Bearer " + UserManager.getAccount(getContext()).getAccessToken());

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
                    temp=temp.replace("[[", "[");
                    temp=temp.replace("]]","]");
                    System.out.println(temp);
                    ArrayList<Group> list = gson.fromJson(temp, new TypeToken<ArrayList<Group>>(){}.getType());
                    adapter.setData(list);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<CommonResult> call, Throwable t) {

            }
        });


        adapter.notifyDataSetChanged();
    }
}