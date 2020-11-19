package com.chlwhdtn.grouping.Data;

import android.net.Uri;

import java.util.ArrayList;

public class Group {
    private String title;
    private String inviteCode;
    private Object member;
    private Object schedule;

    public Group(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Object getMember() {
        return member;
    }

    public void setMember(Object member) {
        this.member = member;
    }

    public Object getSchedule() {
        return schedule;
    }

    public void setSchedule(Object schedule) {
        this.schedule = schedule;
    }
}
