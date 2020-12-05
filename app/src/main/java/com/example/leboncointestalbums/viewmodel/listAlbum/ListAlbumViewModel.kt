package com.example.leboncointestalbums.viewmodel.listAlbum

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.leboncointestalbums.model.entity.Album
import com.example.leboncointestalbums.model.repository.AlbumRepository

class ListAlbumViewModel (application: Application):AndroidViewModel(application){

    private val repository  = AlbumRepository()
    val showProgress : LiveData<Boolean>
    val albumList : LiveData<List<Album>>

    init {
        this.showProgress = repository.showProgress
        this.albumList = repository.albumList
    }

    fun getAlbums(){
        repository.getAlbums()
    }
}