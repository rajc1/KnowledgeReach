package com.example.chetanrajjain.knowledgereach.dummy.ClassRooms;

import com.example.chetanrajjain.knowledgereach.dummy.Objects.POJO;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface NetworkCall {

    @GET("/common/json_feed.html")
    Call<POJO> getProjects(@Query("keyword")String keyword, @Query("APIKey")String key);
}
