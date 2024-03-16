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
import java.sql.Time

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
    private lateinit var Menu7: TextView

    private lateinit var Time1: TextView
    private lateinit var Time2: TextView
    private lateinit var Time3: TextView
    private lateinit var Time4: TextView
    private lateinit var Time5: TextView
    private lateinit var Time6: TextView
    private lateinit var Time7: TextView

    private lateinit var Start: Button

    val listGet2 = Play()//ここ大事やで

    var listed2 = mutableListOf(
        mutableListOf<Any>(5, "ArmMenu"), // <時間とメニュー名>、<時間と休憩>を交互に
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        Menu1 = findViewById<TextView>(R.id.menu1)
        Menu2 = findViewById<TextView>(R.id.menu2)
        Menu3 = findViewById<TextView>(R.id.menu3)
        Menu4 = findViewById<TextView>(R.id.menu4)
        Menu5 = findViewById<TextView>(R.id.menu5)
        Menu6 = findViewById<TextView>(R.id.menu6)
        Menu7 = findViewById<TextView>(R.id.menu7)

        Time1 = findViewById<TextView>(R.id.time1)
        Time2 = findViewById<TextView>(R.id.time2)
        Time3 = findViewById<TextView>(R.id.time3)
        Time4 = findViewById<TextView>(R.id.time4)
        Time5 = findViewById<TextView>(R.id.time5)
        Time6 = findViewById<TextView>(R.id.time6)
        Time7 = findViewById<TextView>(R.id.time7)


        val image1 = findViewById<ImageView>(R.id.image1)
        val image2 = findViewById<ImageView>(R.id.image2)
        val image3 = findViewById<ImageView>(R.id.image3)
        val image4 = findViewById<ImageView>(R.id.image4)
        val image5 = findViewById<ImageView>(R.id.image5)
        val image6 = findViewById<ImageView>(R.id.image6)
        val image7 = findViewById<ImageView>(R.id.image7)



        Start = findViewById<Button>(R.id.start)

        Start.setOnClickListener {
            listGet2.getMenu(listed2)//Playにlisted2を送る
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
        var menutime = min / 6 //1メニューにかける時間
        var Bonusmenutime = min % 6 //ボーナスメニューをする時間
        var ThisLoadDegree: Int = 0 //listedの負荷度
        var BonusLoadDegree: Int = 0 //ボーナスメニューの負荷度
        var Bonusmenuname: CharSequence? = null // ボーナスメニューの名前 (//鍛えたい部位のメニューの中で、一番負荷度が高いものを採用)
        var armflag = true
        var legflag = true
        var calfflag = true

        for (i in 0 until 9) {


            if (armflag) {
                armflag = false
                if (listTrain[i][1].toString() == "Rarm" || listTrain[i][1].toString() == "Larm") {
                    for (j in 0 until 5) {
                        if (j == 0) {
                            if (listTrain[i][0].toString() == "5") {
                                Menu1.text = csvData[j].substring(2)
                                Time1.text = "時間 : ${menutime}分"
                                image1.setImageResource(R.drawable.plank_pu)

                                listed2[0][0] = 45
                                listed2[0][1] = Menu1.text
                                listed2.add(mutableListOf<Any>(15, "休憩"))

                                for (k in 1 until menutime) {
                                    listed2.add(mutableListOf<Any>(45, Menu1.text))
                                    listed2.add(mutableListOf<Any>(15, "休憩"))
                                }


                                if (trainingPart[0] == true || trainingPart[1] == true) Bonusmenuname =
                                    Menu1.text
                            }
                        } else {
                            LoadDegree = csvData[j][0].toString()
                            if (listTrain[i][0].toString() == LoadDegree) {
                                Menu1.text = csvData[j].substring(1)
                                Time1.text = "時間 : ${menutime}分"
                                if (LoadDegree == "5") image1.setImageResource(R.drawable.plank_pu)
                                if (LoadDegree == "4") image1.setImageResource(R.drawable.diamond_pu)
                                if (LoadDegree == "3") image1.setImageResource(R.drawable.diamond_pu_knee)
                                if (LoadDegree == "2") image1.setImageResource(R.drawable.plank_pu_knee)
                                if (LoadDegree == "1") image1.setImageResource(R.drawable.floor_dips)

                                listed2[0][0] = 45
                                listed2[0][1] = Menu1.text
                                listed2.add(mutableListOf<Any>(15, "休憩"))

                                for (k in 1 until menutime) {
                                    listed2.add(mutableListOf<Any>(45, Menu1.text))
                                    listed2.add(mutableListOf<Any>(15, "休憩"))
                                }

                                if (trainingPart[0] == true || trainingPart[1] == true) {
                                    ThisLoadDegree = listTrain[i][0] as Int
                                    if (ThisLoadDegree > BonusLoadDegree) {
                                        Bonusmenuname = Menu1.text
                                        BonusLoadDegree = ThisLoadDegree
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (listTrain[i][1].toString() == "Chest" ) {
                for (j in 5 until 10) {
                    LoadDegree = csvData[j][0].toString()
                    if (listTrain[i][0].toString() == LoadDegree) {
                        Menu2.text = csvData[j].substring(1)
                        Time2.text = "時間 : ${menutime}分"
                        if (LoadDegree == "5") image2.setImageResource(R.drawable.chair_pu)
                        if (LoadDegree == "4") image2.setImageResource(R.drawable.oneleg_pu)
                        if (LoadDegree == "3") image2.setImageResource(R.drawable.normal_pu)
                        if (LoadDegree == "2") image2.setImageResource(R.drawable.normal_pu_knee)
                        if (LoadDegree == "1") image2.setImageResource(R.drawable.wall_pu)

                        for (k in 0 until menutime) {
                            listed2.add(mutableListOf<Any>(45, Menu2.text))
                            listed2.add(mutableListOf<Any>(15, "休憩"))
                        }

                        if (trainingPart[2] == true) {
                            ThisLoadDegree = listTrain[i][0] as Int
                            if (ThisLoadDegree > BonusLoadDegree) {
                                Bonusmenuname = Menu2.text
                                BonusLoadDegree = ThisLoadDegree
                            }
                        }
                    }
                }
            }

            if (listTrain[i][1].toString() == "Stomach" ) {
                for (j in 10 until 15) {
                    LoadDegree = csvData[j][0].toString()
                    if (listTrain[i][0].toString() == LoadDegree) {
                        Menu3.text = csvData[j].substring(1)
                        Time3.text = "時間 : ${menutime}分"
                        if (LoadDegree == "5") image3.setImageResource(R.drawable.toes_touch)
                        if (LoadDegree == "4") image3.setImageResource(R.drawable.v_stomach)
                        if (LoadDegree == "3") image3.setImageResource(R.drawable.knee_to_chest)
                        if (LoadDegree == "2") image3.setImageResource(R.drawable.leg_raise)
                        if (LoadDegree == "1") image3.setImageResource(R.drawable.crunch)

                        for (k in 0 until menutime) {
                            listed2.add(mutableListOf<Any>(45, Menu3.text))
                            listed2.add(mutableListOf<Any>(15, "休憩"))
                        }

                        if (trainingPart[3] == true) {
                            ThisLoadDegree = listTrain[i][0] as Int
                            if (ThisLoadDegree > BonusLoadDegree) {
                                Bonusmenuname = Menu3.text
                                BonusLoadDegree = ThisLoadDegree
                            }
                        }
                    }
                }
            }


            if (listTrain[i][1].toString() == "Rleg" || listTrain[i][1].toString() == "Lleg") {
                if (legflag) {
                    legflag = false
                    for (j in 15 until 20) {
                        LoadDegree = csvData[j][0].toString()
                        if (listTrain[i][0].toString() == LoadDegree) {
                            Menu4.text = csvData[j].substring(1)
                            Time4.text = "時間 : ${menutime}分"
                            if (LoadDegree == "5") image4.setImageResource(R.drawable.jumping_squat)
                            if (LoadDegree == "4") image4.setImageResource(R.drawable.bulgarian_squat)
                            if (LoadDegree == "3") image4.setImageResource(R.drawable.side_squat)
                            if (LoadDegree == "2") image4.setImageResource(R.drawable.full_squat)
                            if (LoadDegree == "1") image4.setImageResource(R.drawable.normal_squat)

                            for (k in 0 until menutime) {
                                listed2.add(mutableListOf<Any>(45, Menu4.text))
                                listed2.add(mutableListOf<Any>(15, "休憩"))
                            }

                            if (trainingPart[4] == true || trainingPart[5] == true) {
                                ThisLoadDegree = listTrain[i][0] as Int
                                if (ThisLoadDegree > BonusLoadDegree) {
                                    Bonusmenuname = Menu4.text
                                    BonusLoadDegree = ThisLoadDegree
                                }
                            }
                        }
                    }
                }
            }

            if (listTrain[i][1].toString() == "Back"){
                for (j in 20 until 25) {
                    LoadDegree = csvData[j][0].toString()
                    if (listTrain[i][0].toString() == LoadDegree) {
                        Menu5.text = csvData[j].substring(1)
                        Time5.text = "時間 : ${menutime}分"
                        if (LoadDegree == "5") image5.setImageResource(R.drawable.pull_up)
                        if (LoadDegree == "4") image5.setImageResource(R.drawable.back_plank_pu)
                        if (LoadDegree == "3") image5.setImageResource(R.drawable.pike_pu)
                        if (LoadDegree == "2") image5.setImageResource(R.drawable.back_extension)
                        if (LoadDegree == "1") image5.setImageResource(R.drawable.towel_rowing)

                        for (k in 0 until menutime) {
                            listed2.add(mutableListOf<Any>(45, Menu5.text))
                            listed2.add(mutableListOf<Any>(15, "休憩"))
                        }

                        if (trainingPart[6] == true) {
                            ThisLoadDegree = listTrain[i][0] as Int
                            if (ThisLoadDegree > BonusLoadDegree) {
                                Bonusmenuname = Menu5.text
                                BonusLoadDegree = ThisLoadDegree
                            }
                        }
                    }
                }
            }

            if (listTrain[i][1].toString() == "Rcalf" || listTrain[i][1].toString() == "Lcalf"){
                if (calfflag) {
                    calfflag = false
                    for (j in 25 until 30) {
                        LoadDegree = csvData[j][0].toString()
                        if (listTrain[i][0].toString() == LoadDegree) {
                            Menu6.text = csvData[j].substring(1)
                            Time6.text = "時間 : ${menutime}分"
                            if (LoadDegree == "5") image6.setImageResource(R.drawable.onstand_oneleg_calf)
                            if (LoadDegree == "4") image6.setImageResource(R.drawable.oneleg_calf)
                            if (LoadDegree == "3") image6.setImageResource(R.drawable.donkey_calf)
                            if (LoadDegree == "2") image6.setImageResource(R.drawable.seated_calf)
                            if (LoadDegree == "1") image6.setImageResource(R.drawable.normal_calf)

                            for (k in 0 until menutime) {
                                listed2.add(mutableListOf<Any>(45, Menu6.text))
                                listed2.add(mutableListOf<Any>(15, "休憩"))
                            }
                            listed2.removeLast()


                            if (trainingPart[7] == true || trainingPart[8] == true) {
                                ThisLoadDegree = listTrain[i][0] as Int
                                if (ThisLoadDegree > BonusLoadDegree) {
                                    Bonusmenuname = Menu6.text
                                    BonusLoadDegree = ThisLoadDegree
                                }
                            }
                        }
                    }
                }
            }
        }

        if (Bonusmenutime != 0) {
            Menu7.text = Bonusmenuname
            Time7.text = "時間 : ${Bonusmenutime}分"

            if (Bonusmenuname == "プランクプッシュアップ") image7.setImageResource(R.drawable.plank_pu)
            if (Bonusmenuname == "ダイヤモンドプッシュアップ") image7.setImageResource(R.drawable.diamond_pu)
            if (Bonusmenuname == "膝つきダイヤモンドプッシュアップ") image7.setImageResource(R.drawable.diamond_pu_knee)
            if (Bonusmenuname == "膝つきプランクプッシュアップ") image7.setImageResource(R.drawable.plank_pu_knee)
            if (Bonusmenuname == "フロアディップス") image7.setImageResource(R.drawable.floor_dips)

            if (Bonusmenuname == "椅子に足をのせてプッシュアップ") image7.setImageResource(R.drawable.chair_pu)
            if (Bonusmenuname == "片足プッシュアップ") image7.setImageResource(R.drawable.oneleg_pu)
            if (Bonusmenuname == "ノーマルプッシュアップ") image7.setImageResource(R.drawable.normal_pu)
            if (Bonusmenuname == "膝つきプッシュアップ") image7.setImageResource(R.drawable.normal_pu_knee)
            if (Bonusmenuname == "壁に手をついてプッシュアップ") image7.setImageResource(R.drawable.wall_pu)

            if (Bonusmenuname == "トゥータッチ") image7.setImageResource(R.drawable.toes_touch)
            if (Bonusmenuname == "V字腹筋") image7.setImageResource(R.drawable.v_stomach)
            if (Bonusmenuname == "ニートゥーチェスト") image7.setImageResource(R.drawable.knee_to_chest)
            if (Bonusmenuname == "レッグレイズ") image7.setImageResource(R.drawable.leg_raise)
            if (Bonusmenuname == "クランチ") image7.setImageResource(R.drawable.crunch)

            if (Bonusmenuname == "ジャンピングスクワット") image7.setImageResource(R.drawable.jumping_squat)
            if (Bonusmenuname == "ブルガリアンスクワット") image7.setImageResource(R.drawable.bulgarian_squat)
            if (Bonusmenuname == "サイドスクワット") image7.setImageResource(R.drawable.side_squat)
            if (Bonusmenuname == "フルスクワット") image7.setImageResource(R.drawable.full_squat)
            if (Bonusmenuname == "ノーマルスクワット") image7.setImageResource(R.drawable.normal_squat)

            if (Bonusmenuname == "懸垂") image7.setImageResource(R.drawable.pull_up)
            if (Bonusmenuname == "バックリバースプランクアップダウン") image7.setImageResource(R.drawable.back_plank_pu)
            if (Bonusmenuname == "パイクプッシュアップ") image7.setImageResource(R.drawable.pike_pu)
            if (Bonusmenuname == "バックエクステンション") image7.setImageResource(R.drawable.back_extension)
            if (Bonusmenuname == "タオルローイング") image7.setImageResource(R.drawable.towel_rowing)

            if (Bonusmenuname == "台の上で片足カーフレイズ") image7.setImageResource(R.drawable.onstand_oneleg_calf)
            if (Bonusmenuname == "片足スタンディングカーフレイズ") image7.setImageResource(R.drawable.oneleg_calf)
            if (Bonusmenuname == "ドンキーカーフレイズ") image7.setImageResource(R.drawable.donkey_calf)
            if (Bonusmenuname == "シーテッドカーフレイズ") image7.setImageResource(R.drawable.seated_calf)
            if (Bonusmenuname == "スタンディングカーフレイズ") image7.setImageResource(R.drawable.normal_calf)

        } else {
            Menu7.text = "ボーナスメニュー"
            Time7.text = "なし"
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


}