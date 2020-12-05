package com.example.leboncointestalbums.model.remote

import com.example.leboncointestalbums.model.entity.Album
import retrofit2.Call
import retrofit2.http.GET




interface IApiServiceAlbum {

    @GET("/img/shared/technical-test.json")
    fun getAlbums(): Call<List<Album?>?>?

}