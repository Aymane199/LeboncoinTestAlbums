package com.example.leboncointestalbums.model.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.leboncointestalbums.model.entity.Album
import com.example.leboncointestalbums.model.remote.IApiServiceAlbum
import com.example.leboncointestalbums.model.remote.RetrofitFactory
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val albumList = MutableLiveData<List<Album>>()


    fun getAlbums() {
        showProgress.value = true
        // Networkcall
        val service = RetrofitFactory.getRetrofit().create(IApiServiceAlbum::class.java)

        service.getAlbums().enqueue(object  : Callback<List<Album>>{
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application,"Error wile accessing the API",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Album>>,
                response: Response<List<Album>>
            ) {
                Log.d("SearchRepository" , "Response : ${Gson().toJson(response.body())}")
                albumList.value = response.body()
                showProgress.value = false
            }

        })
    }
}