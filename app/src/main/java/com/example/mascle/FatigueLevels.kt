package com.example.mascle

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

var flag_fat: Boolean = false
var colorArray = arrayOf(Color.BLACK, Color.RED, Color.YELLOW, Color.CYAN, Color.GREEN)
var countClick = arrayOf(5,5,5,5,5,5,5,5,5,5)
class FatigueLevels : AppCompatActivity(){
    //val adMe = AdoptionMenu()//ここ大事やで←グローバル変数にしました
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fatigurelevels)

        // 次画面への遷移ボタン
        val button = findViewById<Button>(R.id.fat_com)
        button.setOnClickListener {
            adMe.getFatigue(countClick)//疲労度を取得
            val intent = Intent(this, Trained::class.java)
            startActivity(intent)
            finish()
        }

        // 後面への切り替え
        val change_button = findViewById<Button>(R.id.change_back)
        change_button.setOnClickListener {
            startActivity(Intent(this, FatigueLevelsBack::class.java))
        }

        //　右腕の状態疲労度入力
        var rightArm = findViewById<Button>(R.id.right_arm)
        rightArm.setBackgroundColor(colorArray[countClick[0]-1])
        rightArm.setOnClickListener {
            if(countClick[0] == 1) countClick[0] = 5 else countClick[0] = (countClick[0] - 1) % colorArray.size
            rightArm.setBackgroundColor(colorArray[countClick[0]-1])
        }

        var leftArm = findViewById<Button>(R.id.left_arm)
        leftArm.setBackgroundColor(colorArray[countClick[1]-1])
        leftArm.setOnClickListener {
            if(countClick[1] == 1) countClick[1] = 5 else countClick[1] = (countClick[1] - 1) % colorArray.size
            leftArm.setBackgroundColor(colorArray[countClick[1]-1])
        }

        var chest = findViewById<Button>(R.id.chest)
        chest.setBackgroundColor(colorArray[countClick[2]-1])
        chest.setOnClickListener {
            if(countClick[2] == 1) countClick[2] = 5 else countClick[2] = (countClick[2] - 1) % colorArray.size
            chest.setBackgroundColor(colorArray[countClick[2]-1])
        }
        var stomach = findViewById<Button>(R.id.stomach)
        stomach.setBackgroundColor(colorArray[countClick[3]-1])
        stomach.setOnClickListener {
            if(countClick[3] == 1) countClick[3] = 5 else countClick[3] = (countClick[3] - 1) % colorArray.size
            stomach.setBackgroundColor(colorArray[countClick[3]-1])
        }
        var rightLeg = findViewById<Button>(R.id.right_leg)
        rightLeg.setBackgroundColor(colorArray[countClick[4]-1])
        rightLeg.setOnClickListener {
            if(countClick[4] == 1) countClick[4] = 5 else countClick[4] = (countClick[4] - 1) % colorArray.size
            rightLeg.setBackgroundColor(colorArray[countClick[4]-1])
        }
        var leftLeg = findViewById<Button>(R.id.left_leg)
        leftLeg.setBackgroundColor(colorArray[countClick[5]-1])
        leftLeg.setOnClickListener {
            if(countClick[5] == 1) countClick[5] = 5 else countClick[5] = (countClick[5] - 1) % colorArray.size
            leftLeg.setBackgroundColor(colorArray[countClick[5]-1])
        }
    }
}

class FatigueLevelsBack : AppCompatActivity() {
    //val adMe = AdoptionMenu()//ここ大事やで

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fatigure_back)

        //前面への切り替え
        val change_button = findViewById<Button>(R.id.change_front)
        change_button.setOnClickListener {
            startActivity(Intent(this, FatigueLevels::class.java))
        }

        //次画面への遷移ボタン
        val button = findViewById<Button>(R.id.tra_com_back)
        button.setOnClickListener {
            adMe.getFatigue(countClick)//疲労度を取得
            val intent = Intent(this, Trained::class.java)
            startActivity(intent)
            finish()
        }

        var back = findViewById<Button>(R.id.back)
        back.setBackgroundColor(colorArray[countClick[6]-1])
        back.setOnClickListener {
            if(countClick[6] == 1) countClick[6] = 5 else countClick[6] = (countClick[6] - 1) % colorArray.size
            back.setBackgroundColor(colorArray[countClick[6]-1])
        }
        var rightcalf = findViewById<Button>(R.id.right_calf)
        rightcalf.setBackgroundColor(colorArray[countClick[7]-1])
        rightcalf.setOnClickListener {
            if(countClick[7] == 1) countClick[7] = 5 else countClick[7] = (countClick[7] - 1) % colorArray.size
            rightcalf.setBackgroundColor(colorArray[countClick[7]-1])
        }
        var leftcalf = findViewById<Button>(R.id.left_calf)
        leftcalf.setBackgroundColor(colorArray[countClick[8]-1])
        leftcalf.setOnClickListener {
            if(countClick[8] == 1) countClick[8] = 5 else countClick[8] = (countClick[8] - 1) % colorArray.size
            leftcalf.setBackgroundColor(colorArray[countClick[8]-1])
        }
    }
}