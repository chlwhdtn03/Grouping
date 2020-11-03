package com.chlwhdtn.grouping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HomeFragment extends Fragment {

    TextView home_more_group, schedule_create;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        home_more_group = v.findViewById(R.id.home_more_group);
        schedule_create = v.findViewById(R.id.home_more_schedule);

        home_more_group.setOnClickListener(item -> {
            startActivity(new Intent(v.getContext(), CreateGroupActivity.class));
        });

        schedule_create.setOnClickListener(item -> {
            startActivity(new Intent(v.getContext(), ScheduleCreateActivity.class)); // 지우기!! 테스트용
        });

        return v;
    }
}