package com.chlwhdtn.grouping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.Schedule;
import com.chlwhdtn.grouping.Retrofit.GroupingRetrofit;
import com.chlwhdtn.grouping.Retrofit.GroupingService;
import com.chlwhdtn.grouping.Util.UserManager;
import com.chlwhdtn.grouping.adapter.ScheduleAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarFragment extends Fragment {

    DatePicker datePicker;
    RecyclerView schedules;
    ScheduleAdapter adapter = new ScheduleAdapter();;

    String currentDate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendar, container, false);

        datePicker = v.findViewById(R.id.calendar_datepicker);
        schedules = v.findViewById(R.id.calendar_recyclerview);

        Calendar cal = Calendar.getInstance();
        datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), (datePicker1, i, i1, i2) -> {
            currentDate = i + "/" + (i1 + 1) + "/" + i2;
            LoadSchedule();
        });
        currentDate = cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DAY_OF_MONTH);

        schedules.setAdapter(adapter);
        LoadSchedule();

        return v;
    }


    private void LoadSchedule() {
        adapter.list.clear();
        adapter.notifyDataSetChanged();
        GroupingService retrofit = GroupingRetrofit.getInstance(getContext()).getGroupingService();
        Call<CommonResult> response = retrofit.getSchedulesbyDate("Bearer " + UserManager.getAccount(getContext()).getAccessToken(), currentDate);

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
                    temp = temp.replace("[[","[");
                    temp = temp.replace("]]","]");
                    System.out.println(temp);
                    ArrayList<Schedule> list = gson.fromJson(temp, new TypeToken<ArrayList<Schedule>>(){}.getType());
                    adapter.setData(list);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<CommonResult> call, Throwable t) {

            }
        });

    }
}