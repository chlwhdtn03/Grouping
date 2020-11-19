package com.chlwhdtn.grouping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.LoginObject;
import com.chlwhdtn.grouping.Data.RequestGroupCreate;
import com.chlwhdtn.grouping.Data.RequestJoinGroup;
import com.chlwhdtn.grouping.Retrofit.GroupingRetrofit;
import com.chlwhdtn.grouping.Retrofit.GroupingService;
import com.chlwhdtn.grouping.Util.MessageBox;
import com.chlwhdtn.grouping.Util.MessageType;
import com.chlwhdtn.grouping.Util.UserManager;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateGroupActivity extends AppCompatActivity {

    EditText joingroup_edit, creategroup_edit;
    Button joingroup_btn, creategroup_btn;
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        joingroup_btn = findViewById(R.id.joingroup_btn);
        joingroup_edit = findViewById(R.id.joingroup_name);

        creategroup_btn = findViewById(R.id.creategroup_btn);
        creategroup_edit = findViewById(R.id.creategroup_name);

        creategroup_btn.setOnClickListener(item -> {
            if(creategroup_edit.getText().toString().trim().isEmpty()) {
                MessageBox.show(item, "그룹 이름을 입력하세요.", MessageType.ERROR);
                return;
            }
            GroupingService retrofit = GroupingRetrofit.getInstance(getBaseContext()).getGroupingService();
            Call<CommonResult> response = retrofit.createGroup("Bearer " + UserManager.getAccount(this).getAccessToken(), new RequestGroupCreate(creategroup_edit.getText().toString()));

            response.enqueue(new Callback<CommonResult>() {
                @Override
                public void onResponse(Call<CommonResult> call, Response<CommonResult> response) {
                    CommonResult result = response.body();

                    if(result == null) {
                        try { result = new Gson().fromJson(response.errorBody().string(), CommonResult.class); }
                        catch (IOException e) { e.printStackTrace(); }
                    }

                    if(result.isSuccess()) {
                        MessageBox.show(item, result.getMessage(), MessageType.DONE);
                    } else {
                        MessageBox.show(item, result.getMessage(), MessageType.ERROR);
                    }

                }

                @Override
                public void onFailure(Call<CommonResult> call, Throwable t) {

                }
            });
        });

        joingroup_btn.setOnClickListener(item -> {
            if(joingroup_edit.getText().toString().isEmpty()) {
                MessageBox.show(item, "그룹 코드를 입력하세요", MessageType.ERROR);
                return;
            }
            GroupingService retrofit = GroupingRetrofit.getInstance(getBaseContext()).getGroupingService();
            Call<CommonResult> response = retrofit.joinGroup("Bearer " + UserManager.getAccount(this).getAccessToken(), new RequestJoinGroup(joingroup_edit.getText().toString()));

            response.enqueue(new Callback<CommonResult>() {
                @Override
                public void onResponse(Call<CommonResult> call, Response<CommonResult> res) {
                    CommonResult result = res.body();

                    if(result == null) {
                        try { result = new Gson().fromJson(res.errorBody().string(), CommonResult.class); }
                        catch (IOException e) { e.printStackTrace(); }
                    }

                    if(result.isSuccess()) {
                        MessageBox.show(item, result.getMessage(), MessageType.DONE);
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

        backbtn = findViewById(R.id.group_back);

        backbtn.setOnClickListener(item -> {
            finish();
        });
    }
}