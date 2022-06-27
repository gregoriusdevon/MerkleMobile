package com.merkle.DB;

import com.merkle.Data.Model.Carts.Cart;
import com.merkle.Data.Model.Job;
import com.merkle.Data.Model.Users.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiEndPoints {
    @FormUrlEncoded
    @POST("auth/login")
    Call<User> login(
            @Field("username") String username,
            @Field("password") String password);

    @GET("users")
    Call<List<User>> readUsers();

    @GET("carts")
    Call<List<Cart>> readCarts();

    @GET("positions.json")
    Call<List<Job>> readJobs();

    @GET
    Call<List<Job>> searchJob(@Url String url);

    @GET
    Call<Job> readDetail(@Url String url);
}
