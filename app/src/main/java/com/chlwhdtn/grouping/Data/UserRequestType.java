package com.chlwhdtn.grouping.Data;

import java.util.List;

public class UserRequestType {

    private List<String> type;

    public UserRequestType(List<String> type) {
        this.type = type;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }
}
