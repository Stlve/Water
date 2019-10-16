package com.example.sss;

//
public class SubmitResponse {
    int status;
    Data data;
    static class Data {
        String msg;
    }

    public int getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
