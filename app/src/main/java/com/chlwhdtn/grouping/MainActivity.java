package com.chlwhdtn.grouping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView menu;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.main_menu);
        toolbar = findViewById(R.id.main_toolbar);

        menu.setOnNavigationItemSelectedListener(item -> {
            changeFragment(item.getItemId());
            return true;
        });

        changeFragment(0);

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