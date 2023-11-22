package com.grimjowd.tarquitour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Restaurantes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurantes)

        val Btn = findViewById<Button>(R.id.btn)
        val Btn1 = findViewById<Button>(R.id.btn1)
        val Btn8 = findViewById<Button>(R.id.btn8)
        val Btn2 = findViewById<Button>(R.id.btn2)
        val Btn3 = findViewById<Button>(R.id.btn3)
        val Btn4 = findViewById<Button>(R.id.btn4)
        val Btn5 = findViewById<Button>(R.id.btn5)
        val Btn6 = findViewById<Button>(R.id.btn6)
        val Btn7 = findViewById<Button>(R.id.btn7)





        Btn.setOnClickListener {
            val intent = Intent (this, ActivityRestauranteSaborallano::class.java)
            startActivity(intent)
        }
        Btn1.setOnClickListener {
            val intent = Intent (this, ActivityRestauranteBocador::class.java)
            startActivity(intent)
        }
        Btn8.setOnClickListener {
            val intent = Intent (this, ActivityRestauranteEpa::class.java)
            startActivity(intent)
        }
        Btn2.setOnClickListener {
            val intent = Intent (this, ActivityRestauranteMickys::class.java)
            startActivity(intent)
        }
        Btn3.setOnClickListener {
            val intent = Intent (this, ActivityRestaurantePregopizza::class.java)
            startActivity(intent)
        }
        Btn4.setOnClickListener {
            val intent = Intent (this, ActivityRestauranteAsaderolb::class.java)
            startActivity(intent)
        }
        Btn5.setOnClickListener {
            val intent = Intent (this, ActivityRestauranteHotburguer::class.java)
            startActivity(intent)
        }
        Btn6.setOnClickListener {
            val intent = Intent (this, ActivityRestauranteCecy::class.java)
            startActivity(intent)
        }
        Btn7.setOnClickListener {
            val intent = Intent (this, ActivityRestauranteMiranchito::class.java)
            startActivity(intent)
        }
    }
}