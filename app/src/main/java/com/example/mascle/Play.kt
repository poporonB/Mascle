package com.example.mascle

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timerTask
import android.util.Log

class Play : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
    }
}


class TimeMascle {
    val timer = Timer()

    fun time(time:Long){
        val task = timerTask{
            Log.d("TAG","いけるやよ$time")
        }

        timer.schedule(task,time)
    }
}