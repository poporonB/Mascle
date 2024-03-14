package com.example.mascle

import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var listTrain: List<List<Any>>
var min : Int = 0//確保できた時間
var trainingPart = arrayOf(false,false,false,false,false,false,false,false,false)//筋トレしたい場所

class MenuList : AppCompatActivity() {

    private lateinit var Menu1: TextView
    private lateinit var Menu2: TextView
    private lateinit var Menu3: TextView
    private lateinit var Menu4: TextView
    private lateinit var Menu5: TextView
    private lateinit var Menu6: TextView
    //private lateinit var Menu7: TextView
    //private lateinit var Menu8: TextView
    //private lateinit var Menu9: TextView

    private lateinit var Time1: TextView
    private lateinit var Time2: TextView
    private lateinit var Time3: TextView
    private lateinit var Time4: TextView
    private lateinit var Time5: TextView
    private lateinit var Time6: TextView

    private lateinit var Start: Button
    private var getMenu = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        Menu1 = findViewById<TextView>(R.id.menu1)
        Menu2 = findViewById<TextView>(R.id.menu2)
        Menu3 = findViewById<TextView>(R.id.menu3)
        Menu4 = findViewById<TextView>(R.id.menu4)
        Menu5 = findViewById<TextView>(R.id.menu5)
        Menu6 = findViewById<TextView>(R.id.menu6)
        //Menu7 = findViewById<TextView>(R.id.menu7)
        //Menu8 = findViewById<TextView>(R.id.menu8)
        //Menu9 = findViewById<TextView>(R.id.menu9)

        Time1 = findViewById<TextView>(R.id.time1)
        Time2 = findViewById<TextView>(R.id.time2)
        Time3 = findViewById<TextView>(R.id.time3)
        Time4 = findViewById<TextView>(R.id.time4)
        Time5 = findViewById<TextView>(R.id.time5)
        Time6 = findViewById<TextView>(R.id.time6)


        var image1:ImageView = findViewById(R.id.image1)
        var image2:ImageView = findViewById(R.id.image2)
        var image3:ImageView = findViewById(R.id.image3)
        var image4:ImageView = findViewById(R.id.image4)
        var image5:ImageView = findViewById(R.id.image5)
        var image6:ImageView = findViewById(R.id.image6)

        Start = findViewById<Button>(R.id.start)

        Start.setOnClickListener {
            val intent = Intent(this, Play::class.java)
            startActivity(intent)
            finish()
        }

        val csvFileName = "trainingdata.csv"
        val csvData = readCSVFromAssets(this, csvFileName)
        var LoadDegree: String

        val trueCount = trainingPart.count { it }
        val result = min.toFloat() / trueCount
        val resultWithoutDecimal = result.toInt()


        for(i in trainingPart.indices) {
            if (trainingPart[i]) {
                //　メニュー1
                if (listTrain[i][1].toString() == "Rarm" || listTrain[i][1].toString() == "Larm") {
                    for (j in 0 until 5) {
                        if (j == 0) {
                            LoadDegree = csvData[j][1].toString()
                            if (listTrain[i][0].toString() == LoadDegree) {
                                Menu1.text = csvData[j].substring(1)
                                Time1.text = "時間 : ${resultWithoutDecimal}分"
                                if (LoadDegree == "5") image1.setImageResource(R.drawable.plank_pu)
                                if (LoadDegree == "4") image1.setImageResource(R.drawable.diamond_pu)
                                if (LoadDegree == "3") image1.setImageResource(R.drawable.diamond_pu_knee)
                                if (LoadDegree == "2") image1.setImageResource(R.drawable.plank_pu_knee)
                                if (LoadDegree == "1") image1.setImageResource(R.drawable.floor_dips)
                            }
                        } else {
                            LoadDegree = csvData[j][0].toString()
                            if (listTrain[i][0].toString() == LoadDegree) {
                                Menu1.text = csvData[j].substring(1)
                                Time1.text = "時間 : ${resultWithoutDecimal}分"
                                if (LoadDegree == "5") image1.setImageResource(R.drawable.plank_pu)
                                if (LoadDegree == "4") image1.setImageResource(R.drawable.diamond_pu)
                                if (LoadDegree == "3") image1.setImageResource(R.drawable.diamond_pu_knee)
                                if (LoadDegree == "2") image1.setImageResource(R.drawable.plank_pu_knee)
                                if (LoadDegree == "1") image1.setImageResource(R.drawable.floor_dips)
                            }
                        }
                    }
                }

                // メニュー2
                if (listTrain[i][1].toString() == "Chest") {
                    for (j in 5 until 10) {
                        LoadDegree = csvData[j][0].toString()
                        if (listTrain[i][0].toString() == LoadDegree) {
                            Menu2.text = csvData[j].substring(1)
                            Time2.text = "時間 : ${resultWithoutDecimal}分"
                            if (LoadDegree == "5") image2.setImageResource(R.drawable.chair_pu)
                            if (LoadDegree == "4") image2.setImageResource(R.drawable.oneleg_pu)
                            if (LoadDegree == "3") image2.setImageResource(R.drawable.normal_pu)
                            if (LoadDegree == "2") image2.setImageResource(R.drawable.normal_pu_knee)
                            if (LoadDegree == "1") image2.setImageResource(R.drawable.wall_pu)
                        }
                    }
                }

                // メニュー3
                if (listTrain[i][1].toString() == "Stomach") {
                    for (j in 10 until 15) {
                        LoadDegree = csvData[j][0].toString()
                        if (listTrain[i][0].toString() == LoadDegree) {
                            Menu3.text = csvData[j].substring(1)
                            Time3.text = "時間 : ${resultWithoutDecimal}分"
                            if (LoadDegree == "5") image3.setImageResource(R.drawable.chair_pu)
                            if (LoadDegree == "4") image3.setImageResource(R.drawable.oneleg_pu)
                            if (LoadDegree == "3") image3.setImageResource(R.drawable.normal_pu)
                            if (LoadDegree == "2") image3.setImageResource(R.drawable.normal_pu_knee)
                            if (LoadDegree == "1") image3.setImageResource(R.drawable.wall_pu)
                        }
                    }
                }

                // メニュー4
                if (listTrain[i][1].toString() == "Rleg" || listTrain[i][1].toString() == "Lleg" ) {
                    for (j in 15 until 20) {
                        LoadDegree = csvData[j][0].toString()
                        if (listTrain[i][0].toString() == LoadDegree) {
                            Menu4.text = csvData[j].substring(1)
                            Time4.text = "時間 : ${resultWithoutDecimal}分"
                            if (LoadDegree == "5") image4.setImageResource(R.drawable.chair_pu)
                            if (LoadDegree == "4") image4.setImageResource(R.drawable.oneleg_pu)
                            if (LoadDegree == "3") image4.setImageResource(R.drawable.normal_pu)
                            if (LoadDegree == "2") image4.setImageResource(R.drawable.normal_pu_knee)
                            if (LoadDegree == "1") image4.setImageResource(R.drawable.wall_pu)
                        }
                    }
                }

                // メニュー5
                if (listTrain[i][1].toString() == "Back") {
                    for (j in 20 until 25) {
                        LoadDegree = csvData[j][0].toString()
                        if (listTrain[i][0].toString() == LoadDegree) {
                            Menu5.text = csvData[j].substring(1)
                            Time5.text = "時間 : ${resultWithoutDecimal}分"
                            if (LoadDegree == "5") image5.setImageResource(R.drawable.chair_pu)
                            if (LoadDegree == "4") image5.setImageResource(R.drawable.oneleg_pu)
                            if (LoadDegree == "3") image5.setImageResource(R.drawable.normal_pu)
                            if (LoadDegree == "2") image5.setImageResource(R.drawable.normal_pu_knee)
                            if (LoadDegree == "1") image5.setImageResource(R.drawable.wall_pu)
                        }
                    }

                }

                // メニュー6
                if (listTrain[i][1].toString() == "Rcalf" || listTrain[i][1].toString() == "Lcalf" ) {
                    for (j in 25 until 30) {
                        LoadDegree = csvData[j][0].toString()
                        if (listTrain[i][0].toString() == LoadDegree) {
                            Menu6.text = csvData[j].substring(1)
                            Time6.text = "時間 : ${resultWithoutDecimal}分"
                            if (LoadDegree == "5") image6.setImageResource(R.drawable.chair_pu)
                            if (LoadDegree == "4") image6.setImageResource(R.drawable.oneleg_pu)
                            if (LoadDegree == "3") image6.setImageResource(R.drawable.normal_pu)
                            if (LoadDegree == "2") image6.setImageResource(R.drawable.normal_pu_knee)
                            if (LoadDegree == "1") image6.setImageResource(R.drawable.wall_pu)
                        }
                    }
                }
            }
        }
    }

    fun readCSVFromAssets(context: Context, fileName: String): List<String> {
        val lines = mutableListOf<String>()
        try {
            val inputStream = context.assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                lines.add(line!!)
            }
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return lines
    }

    fun getList(listed : kotlin.collections.List<kotlin.collections.List<Any>>,time : Int,trainPart:Array<Boolean>){//負荷度と部位と鍛えたい部位をコピー
        listTrain = listed.map{it.toList()}
        min = time
        trainingPart = trainPart
        Log.e("List", listTrain.joinToString()+" "+min+" "+trainingPart.contentToString())

    }
}