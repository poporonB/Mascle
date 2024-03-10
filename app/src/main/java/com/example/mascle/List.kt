package com.example.mascle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mascle.R.id.start
import java.io.BufferedReader
import java.io.InputStreamReader

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val button = findViewById<Button>(start)
        button.setOnClickListener {
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

        // 配列に格納されたCSVデータを使って
        for (data in csvData) {
            // dataに対する処理
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

    fun getList(listed : kotlin.collections.List<kotlin.collections.List<Any>>,time : Int){//負荷度と部位をコピー
        val listTrain = listed.map{it.toList()}
        val min = time
        Log.e("List", listTrain.joinToString()+min)
    }
}
