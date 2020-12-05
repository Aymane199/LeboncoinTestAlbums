package com.example.leboncointestalbums.view.listAlbum.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.leboncointestalbums.R
import com.example.leboncointestalbums.model.entity.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_row_album.view.*
import java.net.URI

class DataAdapterListAlbum(val mContext : Context) : RecyclerView.Adapter<DataAdapterListAlbum.MyViewHolder>(){

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

        //holder.itemView.textViewAlbumId.text =

        Picasso.get()
            .load(Uri.parse(currentItem.thumbnailUrl))
            .placeholder(R.drawable.ic_android_black_24dp).error(R.drawable.ic_android_black_24dp)
            .into(holder.itemView.imageViewThumbnailUrl)


        holder.itemView.rowLayout.setOnClickListener {
            val url = currentItem.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            mContext.startActivity(intent)
        }
    }

}