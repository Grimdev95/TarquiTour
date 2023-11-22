package com.grimjowd.tarquitour

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityRestauranteSaborallano : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_saborallano)

        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.saborllano1, " "))
        movieList.add(MovieModel(R.drawable.saborllano2, " "))
        movieList.add(MovieModel(R.drawable.saborllano3, " "))



        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)

    }



    fun irAInstagram(view: View) {
        val uri = Uri.parse("https://www.instagram.com/sabor_a_llano_/")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }


    fun irAWhatsApp(view: View) {
        val uri = Uri.parse("https://wa.me/312 4250834")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun irAFacebook(view: View) {
        val uri = Uri.parse("https://www.facebook.com/Sabor A Llano")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}