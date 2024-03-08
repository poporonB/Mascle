package com.example.mascle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.fatiguelevels)
        /*button.setOnClickListener {
            val intent = Intent(this, FatigueLevels::class.java)
            startActivity(intent)
            finish()
        }*/
        val intent = Intent(this, Play::class.java)
        startActivity(intent)
        finish()
    }
}