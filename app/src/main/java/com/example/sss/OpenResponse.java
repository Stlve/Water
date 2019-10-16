package com.example.sss;


//出牌的类
public class OpenResponse {
    int status;
    Data data;
    static class Data {
        int id;
        String card;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }
}