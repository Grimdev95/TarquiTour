package com.grimjowd.tarquitour

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityRestauranteBocador : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restautante_bocador)

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



    fun irAInstagram(view: View) {
        val uri = Uri.parse("https://www.instagram.com/elbocadodelrey/")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }


    fun irAWhatsApp(view: View) {
        val uri = Uri.parse("https://wa.me/311 4608056")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun irAFacebook(view: View) {
        val uri = Uri.parse("https://www.facebook.com/El Bocado del Rey")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
