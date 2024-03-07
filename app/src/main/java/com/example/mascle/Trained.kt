package com.example.mascle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Trained : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trained)

        val button = findViewById<Button>(R.id.tra_com)
        button.setOnClickListener {
            val intent = Intent(this, Times::class.java)
            startActivity(intent)
        }
    }
}