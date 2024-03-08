package com.example.mascle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val button = findViewById<Button>(R.id.start)
        button.setOnClickListener {
            val intent = Intent(this, Play::class.java)
            startActivity(intent)
            finish()
        }
    }
}