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
import android.content.Intent

class Play : AppCompatActivity() {
    private lateinit var textMenue: TextView
    private lateinit var textTime: TextView
    private lateinit var startRestart: Button
    var buttonFlag = false //初期状態
    lateinit var timer : Timer
    var count = 0

    val listed = listOf(//ここでメニューを入れている
        listOf<Any>(5,"再度チェスト"),
        listOf<Any>(3,"休憩"),
        listOf<Any>(5,"腹筋"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        textMenue = findViewById<TextView>(R.id.textMenue)
        textTime = findViewById<TextView>(R.id.textTime)
        startRestart = findViewById<Button>(R.id.startRestart)

        startRestart.setOnClickListener {//ボタンを押したとき
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

            buttonFlag = false//trueでタイマー開始のためfalseにもどす
            var remainingTime = Second

            runOnUiThread {
                startRestart.text = "開始"
                textTime.text = "残り時間：${remainingTime}秒"
                textMenue.text = menueName // メニュー名を設定
            }

            timer.schedule(object : TimerTask() {
                override fun run() {
                    if (buttonFlag) {
                        if (remainingTime > 0) {
                            runOnUiThread { textTime.text = "残り時間：${remainingTime}秒" }
                            remainingTime--
                        } else {//タイマーが終わったときの処理
                            cancel() // タイマーを停止
                            if(count+1<listed.size){//もしもメニューがまだ続くなら
                                main(++count)
                            }else{//ここに処理を書かないとアプリが落ちる
                                runOnUiThread {
                                    textTime.text = "お疲れさまでした"
                                    startRestart.text = "戻る"
                                    textMenue.text = ""
                                }
                            }
                        }
                    }
                }
            }, 0, 1000)
        }
    }
    fun buttonPush(){
        if(textTime.text.toString()=="お疲れさまでした"){
            screanTrans()
        }else{
            buttonFlag = !buttonFlag // フラグをトグル
            runOnUiThread {
                startRestart.text = if (buttonFlag) "停止" else "再開"
            } // ボタンのテキストを更新
        }
    }
    fun screanTrans(){
        Log.d("Intent", "インテントやで")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}