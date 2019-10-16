package com.example.sss;

//登录的类
public class LoginResponse {
    int status;
    Data data;
    static class Data {
        int user_id;
        String token;

        public void setToken(String token) {
            this.token = token;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public String getToken() {
            return token;
        }
    }

    public int getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}