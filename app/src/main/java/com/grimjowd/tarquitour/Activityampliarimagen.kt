package com.grimjowd.tarquitour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Activityampliarimagen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activityampliarimagen)

        val ampliadaImageView = findViewById<ImageView>(R.id.ampliadaImageView)
        val imagenAmpliada = intent.getIntExtra("imagenAmpliada", R.drawable.fondo)

        ampliadaImageView.setImageResource(imagenAmpliada)
    }
}