package com.merkle.DB;

import com.merkle.Data.Model.Job;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiEndPoints {
    @GET("positions.json")
    Call<List<Job>> readJobs();

    @GET
    Call<List<Job>> searchJob(@Url String url);

    @GET
    Call<Job> readDetail(@Url String url);
}
