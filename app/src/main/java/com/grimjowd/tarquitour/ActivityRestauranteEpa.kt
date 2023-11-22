package com.grimjowd.tarquitour

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityRestauranteEpa : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_epa)
        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.epa1, " "))
        movieList.add(MovieModel(R.drawable.epa2, " "))
        movieList.add(MovieModel(R.drawable.epa3, " "))
        movieList.add(MovieModel(R.drawable.epa4, " "))
        movieList.add(MovieModel(R.drawable.epa5, " "))
        movieList.add(MovieModel(R.drawable.epa6, " "))
        movieList.add(MovieModel(R.drawable.epa7, " "))
        movieList.add(MovieModel(R.drawable.epa8, " "))
        movieList.add(MovieModel(R.drawable.epa9, " "))




        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)

    }





    fun irAWhatsApp(view: View) {
        val uri = Uri.parse("https://wa.me/316 5313690")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun irAFacebook(view: View) {
        val uri = Uri.parse("https://www.facebook.com/Epa la Arepa")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}