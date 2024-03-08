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
    private lateinit var TextMenue: TextView
    private lateinit var TextTime: TextView
    private lateinit var StartRestart: Button
    var buttonFlag = false //初期状態
    lateinit var timer : Timer
    var count = 0

    val listed = listOf(//ここでメニューを入れている
        listOf<Any>(10,"再度チェスト"),
        listOf<Any>(10,"休憩"),
        listOf<Any>(10,"腹筋"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        TextMenue = findViewById<TextView>(R.id.textMenue)
        TextTime = findViewById<TextView>(R.id.textTime)
        StartRestart = findViewById<Button>(R.id.StartRestart)

        StartRestart.setOnClickListener {//ボタンを押したとき
            buttonPush() // タイマーの状態を切り替える
        }
        timer = Timer()
        main(count)
    }

    fun main(count : Int){
            time(listed[count][0] as Int, listed[count][1] as String)
            //time(10,"さいどチェスト")
    }

    fun time(Second:Int,menueName:String) {
        synchronized(timer) {

            runOnUiThread {
                StartRestart.text = "開始"
                TextMenue.text = menueName // メニュー名を設定
            }
            buttonFlag = false//trueでタイマー開始のためfalseにもどす

            var remainingTime = Second

            timer.schedule(object : TimerTask() {
                override fun run() {
                    if (buttonFlag) {
                        if (remainingTime > 0) {
                            runOnUiThread { TextTime.text = "残り時間：${remainingTime}秒" }
                            remainingTime--
                        } else {//タイマーが終わったときの処理

                            cancel() // タイマーを停止

                            if(count<=listed.size){//もしもメニューがまだ続くなら
                                runOnUiThread {
                                    TextTime.text = "次へ"
                                }
                                main(++count)
                            }else{//ここに処理を書かないとアプリが落ちる
                                runOnUiThread {
                                TextTime.text = "終わり！"
                                }
                            }
                        }
                    }
                }
            }, 0, 1000)
        }
    }
    fun buttonPush(){
            buttonFlag = !buttonFlag // フラグをトグル
            runOnUiThread {
                StartRestart.text = if (buttonFlag) "停止" else "再開"
            } // ボタンのテキストを更新
    }
}