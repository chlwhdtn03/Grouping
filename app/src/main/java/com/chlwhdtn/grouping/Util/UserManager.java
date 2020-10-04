package com.chlwhdtn.grouping.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.chlwhdtn.grouping.Data.Account;
import com.chlwhdtn.grouping.Data.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class UserManager {

    private static User my;

    public static User getMy() {
        return my;
    }

    public static void setMy(User my) {
        UserManager.my = my;
    }

    public static void saveAccount(Context context, String id, String pw, String accessToken) {
        try {
            SharedPreferences sf = context.getSharedPreferences("Account", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sf.edit();
            JSONObject object = new JSONObject();
            object.put("id", id);
            object.put("password", pw);
            object.put("accessToken", accessToken);
            editor.putString("login", object.toString());
            editor.commit();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static Account getAccount(Context context) {
        SharedPreferences sf = context.getSharedPreferences("Account", Context.MODE_PRIVATE);
        return new Gson().fromJson(sf.getString("login", "{}"), Account.class);
    }

    public static boolean hasAccount(Context context) {
        return getAccount(context).getId() != null;
    }

    public static void deleteAccount(Context context) {
        SharedPreferences sf = context.getSharedPreferences("Account", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sf.edit();
        editor.clear();
        editor.commit();
    }

}
