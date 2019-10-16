package com.example.sss;

import java.util.List;
//出牌
public class SubmitRequest {
    int id;
    List<String> card;
    SubmitRequest(int id,List<String> card) {
        this.id = id;
        this.card = card;
        System.out.println(id+" "+card);
    }

    public void setCard(List<String> card) {
        this.card = card;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<String> getCard() {
        return card;
    }
}
