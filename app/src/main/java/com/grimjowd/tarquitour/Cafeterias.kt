package com.grimjowd.tarquitour

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Cafeterias : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafeterias)

        val BtnMc = findViewById<Button>(R.id.btnmacondo)

        BtnMc.setOnClickListener {
            intent = Intent(this, ActivityCafeteriasMacondo::class.java)
            startActivity(intent)
        }
    }
}