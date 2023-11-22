package com.grimjowd.tarquitour

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2


class HomeFragment : Fragment() {
    private lateinit var videosAdapter: VideosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)


        val videoList = listOf(
            VideoItem("android.resource://${requireContext().packageName}/${R.raw.puentepaisaje}", "Atardecer en el Río Magdalena", "Disfruta la serenidad del atardecer en el icónico Río Magdalena"),
            VideoItem("android.resource://${requireContext().packageName}/${R.raw.cafe}", "Café", "Relájate con una taza de café mientras contemplas las majestuosas montañas."),
            VideoItem("android.resource://${requireContext().packageName}/${R.raw.paisaje}", "Puestas de Sol Espectaculares", "Disfruta de la serenidad mientras el sol se despide entre las montañas.")


        )


        videosAdapter = VideosAdapter(videoList)

        val viewPager2: ViewPager2 = rootView.findViewById(R.id.videosViewPager)
        viewPager2.adapter = videosAdapter


        val cardView = rootView.findViewById<CardView>(R.id.templo_parroquial)
        val cardView1 = rootView.findViewById<CardView>(R.id.miradores)
        val cardView2 = rootView.findViewById<CardView>(R.id.cafeterias)
        val cardView3 = rootView.findViewById<CardView>(R.id.hoteles)
        val cardView4 = rootView.findViewById<CardView>(R.id.barberybelleza)
        val cardView5 = rootView.findViewById<CardView>(R.id.arte)
        val cardView6 = rootView.findViewById<CardView>(R.id.restaurantes)

        cardView.setOnClickListener {

            val intent = Intent(activity, ActivityTemploParroquial::class.java)
            startActivity(intent)
        }

        cardView1.setOnClickListener {
            val intent = Intent(activity, MiradoresNaturales::class.java)
            startActivity(intent)
        }

        cardView2.setOnClickListener {
            val intent = Intent(activity, Cafeterias::class.java)
            startActivity(intent)
        }

        cardView3.setOnClickListener {
            val intent = Intent(activity, Hoteles::class.java)
            startActivity(intent)
        }
        cardView4.setOnClickListener {
            val intent = Intent(activity, Barber::class.java)
            startActivity(intent)
        }
        cardView5.setOnClickListener {
            val intent = Intent(activity, Artelocal::class.java)
            startActivity(intent)
        }
        cardView6.setOnClickListener {
            val intent = Intent(activity, Restaurantes::class.java)
            startActivity(intent)
        }



        return rootView
    }
}






