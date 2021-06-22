package com.example.exam.services;

import com.example.exam.models.DataNewResponse;
import com.example.exam.models.Hit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface DataNewsService {
    @Headers("x-api-key: 0jfupdgsukurib8va2fddbbvk")
    @GET("v1/news")
    Call<DataNewResponse> getAllNews(@Query("q") String query, @Query("from") String dateFrom);
}
