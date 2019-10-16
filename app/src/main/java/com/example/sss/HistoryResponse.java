package com.example.sss;

import java.util.List;


public class HistoryResponse {

    int status;
    List<Data> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    public String get(){
        String a = "";
        for (int i=0;i<data.size();i++)
        a = a+"id:"+data.get(i).id+"\n"+"card:"+data.get(i).card+"\n"+"score:"+data.get(i).score+"\n"+
                "timestamp:"+data.get(i).timestamp+"\n";
        return a;
    }

    static class Data {
        int id;

        List<String> card;
        int score;
        int timestamp;
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getCard() {
            return card;
        }

        public void setCard(List<String> card) {
            this.card = card;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String get(){
            String a="";
            for (String s : card) {
                a += s;
            }
            System.out.print(a);
            return a;
        }

    }
}
