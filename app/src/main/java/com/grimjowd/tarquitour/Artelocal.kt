package com.grimjowd.tarquitour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Artelocal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artelocal)

        val Btnja = findViewById<Button>(R.id.btnja)

        Btnja.setOnClickListener {
            intent = Intent(this, ActivityArteJa::class.java )
            startActivity(intent)
        }
    }
}