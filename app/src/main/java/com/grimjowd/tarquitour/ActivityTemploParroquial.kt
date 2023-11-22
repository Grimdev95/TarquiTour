package com.grimjowd.tarquitour
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.grimjowd.tarquitour.databinding.ActivityMainBinding
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class ActivityTemploParroquial : AppCompatActivity() {
    private lateinit var carouselRecyclerview: CarouselRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_templo_parroquial)

        carouselRecyclerview = findViewById(R.id.carouselRecyclerview)

        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.iglesia, "Iglesia"))
        movieList.add(MovieModel(R.drawable.fondo, "Tarqui"))
        movieList.add(MovieModel(R.drawable.iglesia, "Afuera"))
        movieList.add(MovieModel(R.drawable.fondo, "Mapa"))

        val adapter = MovieAdapter(movieList)

        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)
    }
}