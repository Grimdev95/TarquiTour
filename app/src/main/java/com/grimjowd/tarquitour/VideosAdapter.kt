package com.grimjowd.tarquitour

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class VideosAdapter(private val videoItems: List<VideoItem>) :
    RecyclerView.Adapter<VideosAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoView: VideoView = itemView.findViewById(R.id.videoView)
        private val textVideoTitle: TextView = itemView.findViewById(R.id.textVideoTitle)
        private val textVideoDescription: TextView = itemView.findViewById(R.id.textVideoDescription)
        private val videoProgressBar: ProgressBar = itemView.findViewById(R.id.videoProgressBar)

        fun setVideoData(videoItem: VideoItem) {
            textVideoTitle.text = videoItem.videoTitle
            textVideoDescription.text = videoItem.videoDescription

            videoView.setVideoPath(videoItem.videoURL)
            videoView.setOnPreparedListener { mp ->
                videoProgressBar.visibility = View.GONE
                mp.start()
                val videoRatio = mp.videoWidth / mp.videoHeight.toFloat()
                val screenRatio = videoView.width / videoView.height.toFloat()
                val scale = videoRatio / screenRatio
                if (scale >= 1f) {
                    videoView.scaleY = 1f / scale
                } else {
                    videoView.scaleY = 1f / scale
                }
            }

            videoView.setOnCompletionListener { mp -> mp.start() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_container_video,
            parent,
            false
        )
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.setVideoData(videoItems[position])
    }

    override fun getItemCount(): Int {
        return videoItems.size
    }
}