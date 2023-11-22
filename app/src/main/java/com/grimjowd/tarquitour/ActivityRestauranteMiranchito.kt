package com.grimjowd.tarquitour

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityRestauranteMiranchito : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_miranchito)

        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.ranchito1, " "))
        movieList.add(MovieModel(R.drawable.ranchito2, " "))
        movieList.add(MovieModel(R.drawable.ranchito3, " "))
        movieList.add(MovieModel(R.drawable.ranchito4, " "))
        movieList.add(MovieModel(R.drawable.ranchito5, " "))
        movieList.add(MovieModel(R.drawable.ranchito6, " "))



        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)

    }





    fun irAWhatsApp(view: View) {
        val uri = Uri.parse("https://wa.me/311 8299438")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun irAFacebook(view: View) {
        val uri = Uri.parse("https://www.facebook.com/Restaurante y Asadero Mi Ranchito")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
