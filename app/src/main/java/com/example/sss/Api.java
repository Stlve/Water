package com.example.sss;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    //注册
    @POST("auth/register")
    Call<RegisterResponse> register(@Body UserDto user);

    //登录
    @POST("auth/login")
    Call<LoginResponse> login(@Body UserDto user);

    //开启战局
    @POST("game/open")
    Call<OpenResponse> open(@Header("X-Auth-Token") String token);

    //出牌 你在哪出牌的
    @POST("game/submit")
    Call<SubmitResponse> submit(@Header("X-Auth-Token") String token, @Body SubmitRequest request);

    //排行榜
    @GET("rank")
    Call<List<leaderResponse>> getrank();
    //历史战局列表
    @GET("history")
    Call<HistoryResponse> history(@Header("X-Auth-Token") String token,
                                  @Query("player_id") int playid,
                                  @Query("limit") int limit,
                                  @Query("page") int page);
    //详情
    @GET("history/{id}")
    Call<HistoryDetailResponse> historydetail(@Header("X-Auth-Token") String token,
                                              @Path("id") int id);

    //历史战局详情
        //@Header("X-Auth-Token") @Query()
    // @GET注解的作用:采用Get方法发送网络请求

    // getCall() = 接收网络请求数据的方法
    // 其中返回类型为Call<*>，*是接收数据的类（即上面定义的Translation类）
    // 如果想直接获得Responsebody中的内容，可以定义网络请求返回值为Call<ResponseBody>
}
