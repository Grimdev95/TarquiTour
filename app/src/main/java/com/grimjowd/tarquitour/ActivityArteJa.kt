package com.grimjowd.tarquitour

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityArteJa : AppCompatActivity() {

    private lateinit var carouselRecyclerview: CarouselRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arte_ja)

        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.macondo2, " "))
        movieList.add(MovieModel(R.drawable.macondo3, " "))
        movieList.add(MovieModel(R.drawable.macondo4, " "))
        movieList.add(MovieModel(R.drawable.macondo5, " "))


        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)

    }



    fun irAInstagram(view: View) {
        val uri = Uri.parse("https://www.instagram.com/jovatosort/")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    fun irAFacebook(view: View) {
        val uri = Uri.parse("https://www.facebook.com/Jovas26")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }


    fun irAWhatsApp(view: View) {
        val uri = Uri.parse("https://wa.me/312 5192949")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}