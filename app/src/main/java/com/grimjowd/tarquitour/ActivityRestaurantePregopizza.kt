package com.grimjowd.tarquitour

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityRestaurantePregopizza : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_pregopizza)
        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.bocado1, " "))
        movieList.add(MovieModel(R.drawable.bocado2, " "))
        movieList.add(MovieModel(R.drawable.bocado3, " "))
        movieList.add(MovieModel(R.drawable.bocado4, " "))
        movieList.add(MovieModel(R.drawable.bocado5, " "))
        movieList.add(MovieModel(R.drawable.bocado6, " "))



        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)

    }





    fun irAWhatsApp(view: View) {
        val uri = Uri.parse("https://wa.me/313 6155127")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun irAFacebook(view: View) {
        val uri = Uri.parse("https://www.facebook.com/Prego's Pizza Tarqui")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}