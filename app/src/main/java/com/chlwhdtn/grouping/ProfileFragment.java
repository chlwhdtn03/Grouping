package com.chlwhdtn.grouping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chlwhdtn.grouping.Util.UserManager;

public class ProfileFragment extends Fragment {

    TextView username, id;
    Button logout_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        username = view.findViewById(R.id.profile_username);
        id = view.findViewById(R.id.profile_id);

        username.setText(UserManager.getMy().getUsername());
        id.setText(UserManager.getMy().getId());

        logout_btn = view.findViewById(R.id.profile_logout_btn);
        logout_btn.setOnClickListener(v -> {
            UserManager.deleteAccount(getContext());
        });

        return view;
    }
}