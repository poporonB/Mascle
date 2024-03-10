package com.example.mascle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

var Tlevel : Int = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Adv = findViewById<Button>(R.id.advanced)
        Adv.setOnClickListener {
            Tlevel = 3
            startActivity(Intent(this, FatigueLevels::class.java))
            finish()
        }

        val Int = findViewById<Button>(R.id.intermediate)
        Int.setOnClickListener{
            Tlevel = 2
            startActivity(Intent(this, FatigueLevels::class.java))
            finish()
        }

        val Beg = findViewById<Button>(R.id.beginner)
        Beg.setOnClickListener{
            Tlevel = 1
            startActivity(Intent(this, FatigueLevels::class.java))
            finish()
        }
    }
}