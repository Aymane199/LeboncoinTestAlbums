package com.example.leboncointestalbums

import com.example.leboncointestalbums.model.entity.Album
import com.example.leboncointestalbums.model.remote.IApiServiceAlbum
import com.example.leboncointestalbums.model.remote.RetrofitFactory
import com.google.gson.Gson
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.CountDownLatch
import org.junit.Assert.*

class ApiCallTest{
    val tag = "ApiCallTest"

    /*
    * assert if the call return something
     */
    @Test
    fun callApi_isSuccessful() {
        System.out.println("callApi_isSuccessful<<")
        val latch = CountDownLatch(1)
        var listAlbum : List<Album> = ArrayList<Album>()
        var onResponseIsSuccessful : Boolean = false
        // Networkcall
        val service = RetrofitFactory.getRetrofit().create(IApiServiceAlbum::class.java)

        service.getAlbums().enqueue(object  : Callback<List<Album>>{
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                onResponseIsSuccessful= false
                latch.countDown()
            }

            override fun onResponse(
                call: Call<List<Album>>,
                response: Response<List<Album>>
            ) {
                //System.out.println( "Response : ${Gson().toJson(response.body())}")
                onResponseIsSuccessful= true
                listAlbum = response.body()!!
                latch.countDown()

            }

        })

        //Wait for api response async
        try {
            latch.await()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        assert(onResponseIsSuccessful)
        assert(listAlbum.isNotEmpty())
        System.out.println( "callApi_isSuccessful>>")
    }


}