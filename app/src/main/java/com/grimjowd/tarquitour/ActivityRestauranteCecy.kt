package com.grimjowd.tarquitour

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityRestauranteCecy : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_cecy)
        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.sason1, " "))
        movieList.add(MovieModel(R.drawable.sason2, " "))
        movieList.add(MovieModel(R.drawable.sason3, " "))
        movieList.add(MovieModel(R.drawable.sason4, " "))
        movieList.add(MovieModel(R.drawable.sason5, " "))
        movieList.add(MovieModel(R.drawable.sason6, " "))
        movieList.add(MovieModel(R.drawable.sason7, " "))



        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)

    }




    fun irAWhatsApp(view: View) {
        val uri = Uri.parse("https://wa.me/310 2050657")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun irAFacebook(view: View) {
        val uri = Uri.parse("https://www.facebook.com/La Sazon De Cecy ")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
