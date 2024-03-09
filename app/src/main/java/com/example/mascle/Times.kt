package com.example.mascle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.utils.ViewTimeCycle

class Times : AppCompatActivity(){

    private lateinit var viewTime: TextView
    private lateinit var time5: Button
    private lateinit var time10: Button
    private lateinit var time30: Button
    private lateinit var timeM10: Button
    private lateinit var finish: Button

    private var getTime = "0"
    private var times : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_times)

        finish = findViewById<Button>(R.id.tim_com)
        time5 = findViewById<Button>(R.id.button5)
        time10 = findViewById<Button>(R.id.button10)
        time30 = findViewById<Button>(R.id.button30)
        timeM10 = findViewById<Button>(R.id.buttonM10)
        viewTime = findViewById<TextView>(R.id.ViewTime)

        finish.setOnClickListener{
            val intent = Intent(this, List::class.java)
            startActivity(intent)
            finish()
        }

        time5.setOnClickListener{
            addTime(5)
        }
        time10.setOnClickListener{
            addTime(10)
        }
        time30.setOnClickListener{
            addTime(30)
        }
        timeM10.setOnClickListener{
            addTime(-10)
        }
        viewTime.text = getTime
    }
    fun addTime(time : Int){
        getTime = viewTime.text.toString()//表示されている時間を取得
        times  = getTime.toInt() + time//取得した時間をINT型にして＋５
        getTime = times.toString()//String型に戻す
        viewTime.text = getTime
    }
}