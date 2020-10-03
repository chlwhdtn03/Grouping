package com.chlwhdtn.grouping.Retrofit;

import android.content.Context;

import com.chlwhdtn.grouping.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GroupingRetrofit {

    private static GroupingRetrofit instance;

    private GroupingService dropService;

    public static GroupingRetrofit getInstance(Context context) {
        if (instance == null) {
            instance = new GroupingRetrofit(context);
        }
        return instance;
    }

    private GroupingRetrofit(Context context) {
        Retrofit register = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dropService = register.create(GroupingService.class);
    }

    public GroupingService getGroupingService() {
        return dropService;
    }

}
