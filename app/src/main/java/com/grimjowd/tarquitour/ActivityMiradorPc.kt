package com.grimjowd.tarquitour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityMiradorPc : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mirador_pc)

        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.miradorpc, " "))
        movieList.add(MovieModel(R.drawable.miradorpc1, " "))
        movieList.add(MovieModel(R.drawable.miradorpc2, " "))
        movieList.add(MovieModel(R.drawable.miradorpc3, " "))
        movieList.add(MovieModel(R.drawable.miradorpc4, " "))
        movieList.add(MovieModel(R.drawable.miradorpc5, " "))
        movieList.add(MovieModel(R.drawable.miradorpc6, " "))

        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)
    }
}