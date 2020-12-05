package com.example.leboncointestalbums.view.listAlbum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leboncointestalbums.R
import com.example.leboncointestalbums.model.entity.Album
import kotlinx.android.synthetic.main.custom_row_album.view.*

class DataAdapterListAlbum : RecyclerView.Adapter<DataAdapterListAlbum.MyViewHolder>(){

    private var albumList = emptyList<Album>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row_album,parent,false))
    }

    override fun getItemCount(): Int {
        return albumList.size
    }


    fun setData(list: List<Album>){
        this.albumList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = albumList[position]
        holder.itemView.textViewId.text = currentItem.id.toString()
        holder.itemView.textViewTitle.text = currentItem.title
        holder.itemView.textViewAlbumId.text = currentItem.albumId.toString()

        //holder.itemView.textViewAlbumId.text = currentItem.thumbnailUrl

        holder.itemView.rowLayout.setOnClickListener {
        }
    }

}