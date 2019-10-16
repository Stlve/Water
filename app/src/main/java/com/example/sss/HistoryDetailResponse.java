package com.example.sss;

import java.util.List;

public class HistoryDetailResponse {
    int status;
    Data data;

    public Data getData() {
        return data;
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

    static public class Data {
        int id;
        int timestamp;
        List<Otherdata> detail;

        public void setId(int id) {
            this.id = id;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public void setOtherdata(List<Otherdata> otherdata) {
            this.detail = otherdata;
        }

        public int getId() {
            return id;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public List<Otherdata> getOtherdata() {
            return detail;
        }
    }
    static public class Otherdata{
        int player_id;
        String name;
        int score;
        List<String> card;


        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public int getPlayer_id() {
            return player_id;
        }

        public List<String> getCard() {
            return card;
        }

        public void setPlayer_id(int player_id) {
            this.player_id = player_id;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCard(List<String> card) {
            this.card = card;
        }
    }

    }

