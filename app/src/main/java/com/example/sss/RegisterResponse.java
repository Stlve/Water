package com.example.sss;

//注销
public class RegisterResponse {
    int status;
    Data data;
    static class Data {
        String msg;
        int user_id;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }
}