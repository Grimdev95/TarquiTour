package com.grimjowd.tarquitour

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.grimjowd.tarquitour.databinding.CarouselItemBinding

class MovieAdapter(private var movieList: List<MovieModel>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(val binding: CarouselItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.apply {
            Glide.with(movieImage).load(movie.image).into(movieImage)
            movieName.text = movie.name


            root.setOnClickListener {
                val intent = Intent(root.context, Activityampliarimagen::class.java)
                intent.putExtra("imagenAmpliada", movie.image) // Envía la imagen a la nueva actividad
                root.context.startActivity(intent)
            }
        }
    }
}