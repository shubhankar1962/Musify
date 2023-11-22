package com.example.musicappdeezerapi.network

import com.example.musicappdeezerapi.model.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("X-RapidAPI-Key: e848d78ccbmshcda6467b31b2c48p1b520djsn2375a290d03e" ,
            "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String) : Call<MyData>
}