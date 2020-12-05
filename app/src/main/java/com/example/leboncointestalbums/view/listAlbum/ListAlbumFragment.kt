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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leboncointestalbums.R
import com.example.leboncointestalbums.view.listAlbum.adapter.DataAdapterListAlbum
import com.example.leboncointestalbums.viewmodel.listAlbum.ListAlbumViewModel
import kotlinx.android.synthetic.main.fragment_list_album.view.*


class ListAlbumFragment : Fragment() {

    private lateinit var viewModel: ListAlbumViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_album, container, false)

        //RecycleView
        val adapter = DataAdapterListAlbum()
        val recyclerView = view.recycleView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //ViewModel
        viewModel = ViewModelProvider(this).get(ListAlbumViewModel::class.java)
        viewModel.albumList.observe(viewLifecycleOwner, Observer {
            adapter.setData(viewModel.albumList.value!!)
        })
        viewModel.showProgress.observe(viewLifecycleOwner, Observer {
            view.progressBar.visibility = if (viewModel.showProgress.value == true) View.VISIBLE else View.INVISIBLE

        })

        viewModel.getAlbums()
        return view


    }

}