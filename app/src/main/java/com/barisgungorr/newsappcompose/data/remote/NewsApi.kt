package com.barisgungorr.newsappcompose.data.remote

import com.barisgungorr.newsappcompose.data.remote.dto.NewsResponse
import com.barisgungorr.newsappcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources:String,
        @Query("apiKey") apiKey:String = API_KEY
    ): NewsResponse

}