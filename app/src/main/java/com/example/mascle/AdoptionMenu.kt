package com.example.mascle

import android.content.Intent
import android.util.Log
var times : Int = 0//確保できた時間
var trainedPart = arrayOf(false,false,false,false,false,false,false,false,false)//筋トレしたい場所
var loadPart = arrayOf(0,0,0,0,0,0,0,0,0)//疲労度
var levels : Int = 3//筋トレレベル
class AdoptionMenu (){

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
    fun getFatigue(load : Array<Int>){//負荷をコピー
        loadPart = load.copyOf()
        Log.e("Tag", loadPart.contentToString())
    }
    fun getArea(Area : Array<Boolean>){//鍛えたいエリアをコピー
        trainedPart = Area.copyOf()
        Log.e("Tag", trainedPart.contentToString())
    }
    fun getTimes(min : Int) {//確保した時間をコピー
        times = min
        Log.e("Tag", times.toString())
        main()//今はこうしているけれどゆくゆくは変えたい
    }

    fun loadValue(){//疲労度と負荷について
        for(i in 0 until 9){//鍛えたい部位を疲労度に反映
            if(trainedPart[i])
                loadPart[i] = loadPart[i] + 2
            if(loadPart[i] > 5)
                loadPart[i] = 5
        }

        for(i in 0 until 9){//疲労度と負荷に影響させる
            when(levels){
                1 -> when(loadPart[i]){
                        5,4 -> listed[i][0] = 3
                        3 -> listed[i][0] = 2
                        2,1 -> listed[i][0] = 1
                    }
                2 -> when(loadPart[i]) {
                        5, 4 -> listed[i][0] = 4
                        else -> listed[i][0] = loadPart[i]
                    }
                3 -> listed[i][0] = loadPart[i]
            }
        }
    }

}