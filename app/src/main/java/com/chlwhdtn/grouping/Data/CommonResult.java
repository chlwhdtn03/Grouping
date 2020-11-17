package com.chlwhdtn.grouping.Data;

/**
 * 일반적인 반환값에 사용할 클래스
 */
public class CommonResult {
    private boolean success;
    private boolean result;
    private String message;
    private String accessToken;
    private Object list;
    private User data;
    private int status;

    public void setList(Object list) {
        this.list = list;
    }

    public Object getList() {
        return list;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
