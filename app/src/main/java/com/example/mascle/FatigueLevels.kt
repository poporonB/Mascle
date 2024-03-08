package com.example.mascle

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

var flag_fat: Boolean = false
var colorArray = arrayOf(Color.GREEN, Color.CYAN, Color.YELLOW, Color.RED, Color.BLACK)
var countClick = arrayOf(0,0,0,0,0,0,0)
class FatigueLevels : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fatigurelevels)

        // 後面への切り替え
        val change_button = findViewById<Button>(R.id.change_back)
        change_button.setOnClickListener {
            startActivity(Intent(this, FatigueLevelsBack::class.java))
        }

        // 次画面への遷移ボタン
        val button = findViewById<Button>(R.id.fat_com)
        button.setOnClickListener {
            val intent = Intent(this, Trained::class.java)
            startActivity(intent)
            finish()
        }

        //　右腕の状態疲労度入力
        var rightArm = findViewById<Button>(R.id.right_arm)
        rightArm.setBackgroundColor(colorArray[countClick[0]])
        rightArm.setOnClickListener {
            countClick[0] = (countClick[0] + 1) % colorArray.size
            rightArm.setBackgroundColor(colorArray[countClick[0]])
        }

        var leftArm = findViewById<Button>(R.id.left_arm)
        leftArm.setBackgroundColor(colorArray[countClick[1]])
        leftArm.setOnClickListener {
            countClick[1] = (countClick[1] + 1) % colorArray.size
            leftArm.setBackgroundColor(colorArray[countClick[1]])
        }

        var chest = findViewById<Button>(R.id.chest)
        chest.setBackgroundColor(colorArray[countClick[2]])
        chest.setOnClickListener {
            countClick[2] = (countClick[2] + 1) % colorArray.size
            chest.setBackgroundColor(colorArray[countClick[2]])
        }
        var stomach = findViewById<Button>(R.id.stomach)
        stomach.setBackgroundColor(colorArray[countClick[3]])
        stomach.setOnClickListener {
            countClick[3] = (countClick[3] + 1) % colorArray.size
            stomach.setBackgroundColor(colorArray[countClick[3]])
        }
        var rightLeg = findViewById<Button>(R.id.right_leg)
        rightLeg.setBackgroundColor(colorArray[countClick[4]])
        rightLeg.setOnClickListener {
            countClick[4] = (countClick[4] + 1) % colorArray.size
            rightLeg.setBackgroundColor(colorArray[countClick[4]])
        }
        var leftLeg = findViewById<Button>(R.id.left_leg)
        leftLeg.setBackgroundColor(colorArray[countClick[5]])
        leftLeg.setOnClickListener {
            countClick[5] = (countClick[5] + 1) % colorArray.size
            leftLeg.setBackgroundColor(colorArray[countClick[5]])
        }

    }
}

class FatigueLevelsBack : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fatigure_back)

        //次画面への遷移ボタン
        val button = findViewById<Button>(R.id.fat_com_back)
        button.setOnClickListener {
            val intent = Intent(this, Trained::class.java)
            startActivity(intent)
            finish()
        }
        //前面への切り替え
        val change_button = findViewById<Button>(R.id.change_front)
        change_button.setOnClickListener {
            startActivity(Intent(this, FatigueLevels::class.java))
        }

    }
}