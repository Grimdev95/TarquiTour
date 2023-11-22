package com.grimjowd.tarquitour

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivitySalonmn : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salonmn)

        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.bellezamn, " "))
        movieList.add(MovieModel(R.drawable.bellezamn1, " "))
        movieList.add(MovieModel(R.drawable.bellezamn3, " "))
        movieList.add(MovieModel(R.drawable.bellezamn4, " "))
        movieList.add(MovieModel(R.drawable.bellezamn6, " "))
        movieList.add(MovieModel(R.drawable.bellezamn7, " "))


        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)

    }





    fun irAWhatsApp(view: View) {
        val uri = Uri.parse("https://wa.me/312 6262398") // Reemplaza con tu número de WhatsApp
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}