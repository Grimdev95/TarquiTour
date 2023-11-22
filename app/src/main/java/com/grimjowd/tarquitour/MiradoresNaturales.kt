package com.grimjowd.tarquitour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MiradoresNaturales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_miradores_naturales)

        val Btnpc = findViewById<Button>(R.id.btnpc)
        val Btnse = findViewById<Button>(R.id.btnse)
        val Btnpac = findViewById<Button>(R.id.btnmpc)
        val Btnec = findViewById<Button>(R.id.btnec)

        Btnpc.setOnClickListener {
            val intent = Intent(this, ActivityMiradorPc::class.java)
            startActivity(intent)
        }
        Btnse.setOnClickListener {
            val intent = Intent(this, ActivityMiradorSe::class.java)
            startActivity(intent)
        }
        Btnpac.setOnClickListener {
            val intent = Intent(this, ActivityMiradorPac::class.java)
            startActivity(intent)
        }



    }

}