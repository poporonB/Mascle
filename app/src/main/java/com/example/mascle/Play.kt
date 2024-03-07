package com.example.mascle

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.timer
import java.util.*
import kotlin.concurrent.timerTask
import android.util.Log
import android.widget.TextView
import android.widget.Button

class Play : AppCompatActivity() {
    var timer = Timer()//Timerのなにか
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        time(30)
    }

    var TextMenue = findViewById<TextView>(R.id.textMenue)
    var TextTime = findViewById<TextView>(R.id.textTime)
    var StartRestart = findViewById<Button>(R.id.StartRestart)

    fun time(Second:Int) {
        var remainingtime = Second
        timer(period = 1000) {
            if (remainingtime > 0) {
                TextTime.text = "残り時間：${remainingtime}秒"
                remainingtime--
            }else{
                TextTime.text = "終了！"
            }
        }
    }
}