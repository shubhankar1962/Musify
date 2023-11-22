package com.example.musicappdeezerapi.adapter

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.musicappdeezerapi.R
import com.example.musicappdeezerapi.model.Album
import com.example.musicappdeezerapi.model.Artist
import com.example.musicappdeezerapi.model.Data
import com.example.musicappdeezerapi.model.MyData
import com.squareup.picasso.Picasso

class MyAdapter(val context:Activity,val dataList:List<Data>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val artist = itemView.findViewById<TextView>(R.id.artist)
        val album = itemView.findViewById<TextView>(R.id.album_name)
        val duration = itemView.findViewById<TextView>(R.id.duration)
        val albumImg = itemView.findViewById<ImageView>(R.id.music_item_img)
        val playImg = itemView.findViewById<ImageView>(R.id.playMusicImg)
        val pauseImg = itemView.findViewById<ImageView>(R.id.pauseMusicImg)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.music_list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentlistItem = dataList[position]
        val mediaPlayer = MediaPlayer.create(context, currentlistItem.preview.toUri())
        holder.album.setText(currentlistItem.title)
        Picasso.get().load(currentlistItem.album.cover).into(holder.albumImg)
        holder.artist.setText(currentlistItem.artist.name)
        holder.duration.setText(currentlistItem.duration.toString())

        holder.playImg.setOnClickListener{
            mediaPlayer.start()
        }

        holder.pauseImg.setOnClickListener{
            mediaPlayer.pause()
        }

    }
}