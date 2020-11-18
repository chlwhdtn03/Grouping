package com.chlwhdtn.grouping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.chlwhdtn.grouping.Data.CommonResult;
import com.chlwhdtn.grouping.Data.LoginObject;
import com.chlwhdtn.grouping.Retrofit.GroupingRetrofit;
import com.chlwhdtn.grouping.Retrofit.GroupingService;
import com.chlwhdtn.grouping.Util.MessageBox;
import com.chlwhdtn.grouping.Util.MessageType;
import com.chlwhdtn.grouping.Util.UserManager;

import retrofit2.Call;

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

        joingroup_btn.setOnClickListener(item -> {
            if(joingroup_edit.getText().toString().isEmpty()) {
                MessageBox.show(item, "그룹 코드를 입력하세요", MessageType.ERROR);
            }
            GroupingService retrofit = GroupingRetrofit.getInstance(getBaseContext()).getGroupingService();
            Call<CommonResult> response = retrofit.joinGroup("Bearer " + UserManager.getAccount(this).getAccessToken(), joingroup_edit.getText().toString());
        });

        backbtn = findViewById(R.id.group_back);

        backbtn.setOnClickListener(item -> {
            finish();
        });
    }
}