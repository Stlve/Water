package com.example.sss;

import java.util.List;

public class leaderResponse {

        int player_id;
        String name;
        int score;

        public void setName(String name) {
            this.name = name;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setPlayer_id(int player_id) {
            this.player_id = player_id;
        }

        public int getPlayer_id() {
            return player_id;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
}
