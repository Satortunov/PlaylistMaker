package com.example.playlistmaker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val trackName = itemView.findViewById<TextView>(R.id.trackName)
    private val artistName = itemView.findViewById<TextView>(R.id.artistName)
    private val trackTime = itemView.findViewById<TextView>(R.id.trackTime)
    private val artworkUrl = itemView.findViewById<ImageView>(R.id.artworkUrl)

    fun bind(item: Track) {
        trackName.text = item.trackName
        artistName.text = item.artistName
        trackTime.text = item.trackTime

        Glide.with(itemView)
            .load(item.artworkUrl100)
            .placeholder(R.drawable.placeholder)
            .centerCrop()
            .transform(RoundedCorners(2))
            .into(artworkUrl)


    }
}