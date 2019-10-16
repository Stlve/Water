package com.example.sss;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class Water {
    static String token;
    static String card;
    static int gameId;

    public static void main(String[] args) {
        Network.init();
       register();
        login();
    }

    private static void submit() {
        System.out.println(token);
        String[] splitted = card.split(" ");

        List<String> cards = new ArrayList<>();
        cards.add(splitted[0]+" "+splitted[1]+" "+splitted[2]);
        cards.add(splitted[3]+" "+splitted[4]+" "+splitted[5]+" "+splitted[6]+" "+splitted[7]);
        cards.add(splitted[8]+" "+splitted[9]+" "+splitted[10]+" "+splitted[11]+" "+splitted[12]);
        Network.api.submit(token,new SubmitRequest(gameId,cards)).enqueue(new Callback<SubmitResponse>() {
            @Override
            public void onResponse(Call<SubmitResponse> call, Response<SubmitResponse> response) {

            }

            @Override
            public void onFailure(Call<SubmitResponse> call, Throwable t) {

            }
        });
    }

    private static void open() {
        Network.api.open(token).enqueue(new Callback<OpenResponse>() {
            @Override
            public void onResponse(Call<OpenResponse> call, Response<OpenResponse> response) {
                OpenResponse.Data data = response.body().data;
                card = data.card;
                gameId = data.id;
                System.out.println(card);
                submit();
            }

            @Override
            public void onFailure(Call<OpenResponse> call, Throwable t) {

            }
        });
    }

    private static void login() {
        Network.api.login(new UserDto("031702402","123456")).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                token = (response.body().data.token);
                open();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    private static void register() {
        Network.api.register(new UserDto("031702402","123456")).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                System.out.println(response.body().data.msg);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }
}
