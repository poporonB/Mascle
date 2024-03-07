package com.example.mascle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FatigueLevels : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fatigurelevels)
        
        val button = findViewById<Button>(R.id.fat_com)
        button.setOnClickListener {
            val intent = Intent(this, Trained::class.java)
            startActivity(intent)
            finish()
        }
    }
}