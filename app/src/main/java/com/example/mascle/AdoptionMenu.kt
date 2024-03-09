package com.example.mascle

import android.content.Intent
import android.util.Log

class AdoptionMenu (){
    var times : Int = 0//確保できた時間
    var trainedArea = arrayOf(true,false,false,false,false,false,false,false,true)//筋トレしたい場所
    var countClick = arrayOf(0,0,0,0,0,0,0,0,0,0)//疲労度
    var levels : Int = 3//筋トレレベル

    var listed = mutableListOf(//ここでメニューを入れている
        mutableListOf<Any>(5,"Rarm"),//負荷と部位
        mutableListOf<Any>(5,"Larm"),
        mutableListOf<Any>(5,"Chest"),
        mutableListOf<Any>(5,"Stomach"),
        mutableListOf<Any>(5,"Rleg"),
        mutableListOf<Any>(5,"Lleg"),
        mutableListOf<Any>(5,"Back"),
        mutableListOf<Any>(5,"Rcalf"),
        mutableListOf<Any>(5,"Lcalf")
    )

    fun main(){//関数を組み合わせればよい
        loadValue()
        Log.e("Tag", listed.toString())
    }

    fun cycle(min:Int):Pair<Int,Int>{//1サイクルのセット数と残り時間
        var setTimes = min / 6
        var reminderMin = min % 6

        return Pair(setTimes,reminderMin)
    }
    fun getLoad(load : Array<Int>){//負荷をコピー
        countClick = load.copyOf()
    }
    fun getArea(Area : Array<Boolean>){//鍛えたいエリアをコピー
        trainedArea = Area.copyOf()
    }
    fun getTimes(times : Int) {//確保した時間をコピー
        this.times = times
        //Log.e("Tag", times.toString())
        main()//今はこうしているけれどゆくゆくは変えたい
    }

    fun loadValue(){//疲労度と負荷について
        for(i in 0 until 9){//鍛えたい部位を疲労度に反映
            if(trainedArea[i])
                countClick[i] = countClick[i] + 2
            if(countClick[i] > 5)
                countClick[i] = 5
        }

        for(i in 0 until 9){//疲労度と負荷に影響させる
            if(levels == 1) {
                when(countClick[i]){
                    5,4 -> listed[i][0] = 3
                    3 -> listed[i][0] = 2
                    2,1 -> listed[i][0] = 1
                }
            }else if(levels == 2){
                when(countClick[i]) {
                    5, 4 -> listed[i][0] = 4
                    else -> listed[i][0] = countClick[i]
                }
            }else if(levels == 3){
                    listed[i][0] = countClick[i]
            }
        }
    }

}