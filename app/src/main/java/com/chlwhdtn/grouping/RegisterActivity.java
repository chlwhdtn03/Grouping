package com.chlwhdtn.grouping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {

    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backbtn = findViewById(R.id.reg_back);

        backbtn.setOnClickListener(view -> {
            finish();
        });
    }
}