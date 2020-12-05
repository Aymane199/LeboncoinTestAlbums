package com.example.leboncointestalbums.view.listAlbum

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.leboncointestalbums.R
import com.example.leboncointestalbums.viewmodel.listAlbum.ListAlbumViewModel


class ListAlbumFragment : Fragment() {

    private lateinit var viewModel: ListAlbumViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ListAlbumViewModel::class.java)

        viewModel.albumList.observe(viewLifecycleOwner, Observer {
            Log.d("ListAlbumFragment","albumList : ${viewModel.albumList.value.toString()}")
        })
        viewModel.showProgress.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity,"${viewModel.showProgress.value}",Toast.LENGTH_LONG).show()
        })

        viewModel.getAlbums()

        return inflater.inflate(R.layout.fragment_list_album, container, false)


    }

}