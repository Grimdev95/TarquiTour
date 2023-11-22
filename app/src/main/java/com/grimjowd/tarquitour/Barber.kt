package com.grimjowd.tarquitour

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Barber : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barber)

        val Btnpp = findViewById <Button>(R.id.btnpp)
        val Btnmn = findViewById<Button>(R.id.btnsalonmary)

        Btnpp.setOnClickListener {
            intent = Intent(this, ActivityBarberPP::class.java)
            startActivity(intent)
        }

        Btnmn.setOnClickListener {
            intent = Intent(this, ActivitySalonmn::class.java)
            startActivity(intent)
        }
    }
}