package com.chlwhdtn.grouping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

        backbtn = findViewById(R.id.group_back);

        backbtn.setOnClickListener(item -> {
            finish();
        });
    }
}