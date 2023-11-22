package com.grimjowd.tarquitour

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityBarberPP : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barber_pp)
        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.barberpp1, " "))
        movieList.add(MovieModel(R.drawable.barberpp2, " "))
        movieList.add(MovieModel(R.drawable.barberpp3, " "))
        movieList.add(MovieModel(R.drawable.barberpp4, " "))
        movieList.add(MovieModel(R.drawable.barberpp5, " "))
        movieList.add(MovieModel(R.drawable.barberpp6, " "))
        movieList.add(MovieModel(R.drawable.barberpp7, " "))


        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)
    }


    fun irAWhatsApp(view: View) {
        val uri = Uri.parse("https://wa.me/322 2945525")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
