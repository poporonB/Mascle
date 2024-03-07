package com.example.mascle

import android.content.Intent
import android.os.Bundle
import android.view.View.OnCreateContextMenuListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.List

class Times : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_times)

        val button = findViewById<Button>(R.id.tim_com)
        button.setOnClickListener{
            val intent = Intent(this, List::class.java)
            startActivity(intent)
        }

    }
}