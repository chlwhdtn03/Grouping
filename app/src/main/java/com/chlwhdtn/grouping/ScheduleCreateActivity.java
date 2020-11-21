package com.chlwhdtn.grouping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.LoginObject;
import com.chlwhdtn.grouping.Data.Schedule;
import com.chlwhdtn.grouping.Retrofit.GroupingRetrofit;
import com.chlwhdtn.grouping.Retrofit.GroupingService;
import com.chlwhdtn.grouping.Util.MessageBox;
import com.chlwhdtn.grouping.Util.MessageType;
import com.chlwhdtn.grouping.Util.UserManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleCreateActivity extends AppCompatActivity {

    EditText tv_title, tv_place;
    DatePicker datePicker;
    Button create_btn;

    String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_create);

        tv_title = findViewById(R.id.createSchedule_title);
        tv_place = findViewById(R.id.createSchedule_place);
        datePicker = findViewById(R.id.createSchedule_date);
        Calendar cal = Calendar.getInstance();
        datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), (datePicker1, i, i1, i2) -> {currentDate = i + "/" + (i1 + 1) + "/" + i2;} );
        currentDate = cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(currentDate);
        create_btn = findViewById(R.id.createSchedule_btn);

        create_btn.setOnClickListener(item -> {
            String title = tv_title.getText().toString().trim(), place = tv_place.getText().toString().trim(), date = currentDate;
            if(title.isEmpty() || date.isEmpty()) {
                MessageBox.show(item, "필수 항목을 모두 채워주세요", MessageType.WARNING);
                return;
            }

            GroupingService retrofit = GroupingRetrofit.getInstance(getBaseContext()).getGroupingService();
            Call<CommonResult> response = retrofit.addSchedule("Bearer " + UserManager.getAccount(getBaseContext()).getAccessToken(), new Schedule(title, getIntent().getStringExtra("code"), date, place));

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
                        MessageBox.show(item, result.getMessage(), MessageType.ERROR);
                    }
                }

                @Override
                public void onFailure(Call<CommonResult> call, Throwable t) {

                }
            });

        });

    }
}