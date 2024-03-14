package com.example.mascle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
val adMe = AdoptionMenu()//ここ大事やで

class MainActivity : AppCompatActivity() {
    var Tlevel : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Adv = findViewById<Button>(R.id.advanced)
        Adv.setOnClickListener {
            Tlevel = 3
            adMe.getLevel(Tlevel)//レベルを取得
            startActivity(Intent(this, FatigueLevels::class.java))
            finish()
        }

        val Int = findViewById<Button>(R.id.intermediate)
        Int.setOnClickListener{
            Tlevel = 2
            adMe.getLevel(Tlevel)//レベルを取得
            startActivity(Intent(this, FatigueLevels::class.java))
            finish()
        }

        val Beg = findViewById<Button>(R.id.beginner)
        Beg.setOnClickListener{
            Tlevel = 1
            adMe.getLevel(Tlevel)//レベルを取得
            startActivity(Intent(this, FatigueLevels::class.java))
            finish()
        }
    }
}