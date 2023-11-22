package com.grimjowd.tarquitour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityMiradorPac : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mirador_pac)

        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.miradorpac, " "))
        movieList.add(MovieModel(R.drawable.miradorpac1, " "))
        movieList.add(MovieModel(R.drawable.miradorpac3, " "))
        movieList.add(MovieModel(R.drawable.miradorpac4, " "))


        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)
    }
}
