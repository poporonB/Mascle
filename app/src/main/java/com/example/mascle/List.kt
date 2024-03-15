package com.example.mascle

import android.content.Intent
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

    private lateinit var Start: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        Menu1 = findViewById<TextView>(R.id.menu1)
        Menu2 = findViewById<TextView>(R.id.menu2)
        Menu3 = findViewById<TextView>(R.id.menu3)
        Menu4 = findViewById<TextView>(R.id.menu4)
        Menu5 = findViewById<TextView>(R.id.menu5)
        Menu6 = findViewById<TextView>(R.id.menu6)


        val image1 = findViewById<ImageView>(R.id.image1)
        val image2 = findViewById<ImageView>(R.id.image2)
        val image3 = findViewById<ImageView>(R.id.image3)
        val image4 = findViewById<ImageView>(R.id.image4)
        val image5 = findViewById<ImageView>(R.id.image5)
        val image6 = findViewById<ImageView>(R.id.image6)



        Start = findViewById<Button>(R.id.start)

        Start.setOnClickListener {
            val intent = Intent(this, Play::class.java)
            startActivity(intent)
            finish()
        }

        val lines = readCSVFromAssets("trainingdata.csv") // sample.csv を実際のファイル名に変更する

        // CSVファイルの各行を格納する配列
        val csvData = ArrayList<String>()

        // 読み込んだCSVファイルの各行を配列に格納
        for (line in lines) {
            csvData.add(line)
        }

        var LoadDegree: String //csvファイルの負荷度

        for (i in 0 until 9) {

            if (listTrain[i][1].toString() == "Rarm" || listTrain[i][1].toString() == "Larm") {
                for (j in 0 until 5) {
                    if (j == 0) {
                        LoadDegree = csvData[j][1].toString()
                        if (listTrain[i][0].toString() == LoadDegree) {
                            Menu1.text = csvData[j].substring(1)
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
                            if (LoadDegree == "5") image1.setImageResource(R.drawable.plank_pu)
                            if (LoadDegree == "4") image1.setImageResource(R.drawable.diamond_pu)
                            if (LoadDegree == "3") image1.setImageResource(R.drawable.diamond_pu_knee)
                            if (LoadDegree == "2") image1.setImageResource(R.drawable.plank_pu_knee)
                            if (LoadDegree == "1") image1.setImageResource(R.drawable.floor_dips)
                        }
                    }
                }
            }

            if (listTrain[i][1].toString() == "Chest" ) {
                for (j in 5 until 10) {
                    LoadDegree = csvData[j][0].toString()
                    if (listTrain[i][0].toString() == LoadDegree) {
                        Menu2.text = csvData[j].substring(1)
                        if (LoadDegree == "5") image2.setImageResource(R.drawable.chair_pu)
                        if (LoadDegree == "4") image2.setImageResource(R.drawable.oneleg_pu)
                        if (LoadDegree == "3") image2.setImageResource(R.drawable.normal_pu)
                        if (LoadDegree == "2") image2.setImageResource(R.drawable.normal_pu_knee)
                        if (LoadDegree == "1") image2.setImageResource(R.drawable.wall_pu)
                    }
                }
            }

            if (listTrain[i][1].toString() == "Stomach" ) {
                for (j in 10 until 15) {
                    LoadDegree = csvData[j][0].toString()
                    if (listTrain[i][0].toString() == LoadDegree) {
                        Menu3.text = csvData[j].substring(1)
                        if (LoadDegree == "5") image3.setImageResource(R.drawable.toes_touch)
                        if (LoadDegree == "4") image3.setImageResource(R.drawable.v_stomach)
                        if (LoadDegree == "3") image3.setImageResource(R.drawable.knee_to_chest)
                        if (LoadDegree == "2") image3.setImageResource(R.drawable.leg_raise)
                        if (LoadDegree == "1") image3.setImageResource(R.drawable.crunch)
                    }
                }
            }


            if (listTrain[i][1].toString() == "Rleg" || listTrain[i][1].toString() == "Lleg") {
                for (j in 15 until 20) {
                    LoadDegree = csvData[j][0].toString()
                    if (listTrain[i][0].toString() == LoadDegree) {
                        Menu4.text = csvData[j].substring(1)
                        if (LoadDegree == "5") image4.setImageResource(R.drawable.jumping_squat)
                        if (LoadDegree == "4") image4.setImageResource(R.drawable.bulgarian_squat)
                        if (LoadDegree == "3") image4.setImageResource(R.drawable.side_squat)
                        if (LoadDegree == "2") image4.setImageResource(R.drawable.full_squat)
                        if (LoadDegree == "1") image4.setImageResource(R.drawable.normal_squat)
                    }
                }
            }

            if (listTrain[i][1].toString() == "Back"){
                for (j in 20 until 25) {
                    LoadDegree = csvData[j][0].toString()
                    if (listTrain[i][0].toString() == LoadDegree) {
                        Menu5.text = csvData[j].substring(1)
                        if (LoadDegree == "5") image5.setImageResource(R.drawable.pull_up)
                        if (LoadDegree == "4") image5.setImageResource(R.drawable.back_plank_pu)
                        if (LoadDegree == "3") image5.setImageResource(R.drawable.pike_pu)
                        if (LoadDegree == "2") image5.setImageResource(R.drawable.back_extension)
                        if (LoadDegree == "1") image5.setImageResource(R.drawable.towel_rowing)
                    }
                }
            }

            if (listTrain[i][1].toString() == "Rcalf" || listTrain[i][1].toString() == "Lcalf"){
                for (j in 25 until 30) {
                    LoadDegree = csvData[j][0].toString()
                    if (listTrain[i][0].toString() == LoadDegree) {
                        Menu6.text = csvData[j].substring(1)
                        if (LoadDegree == "5") image6.setImageResource(R.drawable.onstand_oneleg_calf)
                        if (LoadDegree == "4") image6.setImageResource(R.drawable.oneleg_calf)
                        if (LoadDegree == "3") image6.setImageResource(R.drawable.donkey_calf)
                        if (LoadDegree == "2") image6.setImageResource(R.drawable.seated_calf)
                        if (LoadDegree == "1") image6.setImageResource(R.drawable.oneleg_calf)
                    }
                }
            }
        }
    }

    private fun readCSVFromAssets(fileName: String): ArrayList<String> {
        val resultList = ArrayList<String>()
        try {
            val inputStream = assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                resultList.add(line!!)
            }
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return resultList
    }

    fun getList(listed : kotlin.collections.List<kotlin.collections.List<Any>>,time : Int,trainPart:Array<Boolean>){//負荷度と部位と鍛えたい部位をコピー
        listTrain = listed.map{it.toList()}
        min = time
        trainingPart = trainPart
        Log.e("List", listTrain.joinToString()+" "+min+" "+trainingPart.contentToString())
    }

    /*fun getMenu():List<List<Any>>{
        finalList = final
        return finalList
    }*/
}

