package com.chlwhdtn.grouping.Data;

import android.net.Uri;

import java.util.ArrayList;

public class Group {
    private String name;
    private Uri icon;
    private ArrayList<User> users;
    private ArrayList<Schedule> schedules;


    /**
     * @param name 그룹 이름
     * @param icon 그룹 아이콘
     * @param users 소속 유저
     * @param schedules 그룹 일정
     */
    public Group(String name, Uri icon, ArrayList<User> users, ArrayList<Schedule> schedules) {
        this.name = name;
        this.icon = icon;
        this.users = users;
        this.schedules = schedules;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Uri getIcon() {
        return icon;
    }

    public void setIcon(Uri icon) {
        this.icon = icon;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
}
