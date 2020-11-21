package com.chlwhdtn.grouping.Data;

import java.util.ArrayList;

public class ResponseGroupInfo {

    private ArrayList<User> member;
    private String title;
    private String inviteCode;

    public ArrayList<User> getMember() {
        return member;
    }

    public void setMember(ArrayList<User> member) {
        this.member = member;
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
}
