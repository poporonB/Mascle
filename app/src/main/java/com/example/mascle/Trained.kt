package com.example.mascle

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

var checkCol = arrayOf(Color.WHITE, Color.GREEN)
var trainedArea = arrayOf(false,false,false,false,false,false,false,false,false)
class Trained : AppCompatActivity() {
    //val adMe = AdoptionMenu()//ここ大事やで
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trained)

        // 次画面への遷移ボタン
        val button = findViewById<Button>(R.id.tra_com)
        button.setOnClickListener {
            adMe.getArea(trainedArea)//筋トレしたい部位を取得
            val intent = Intent(this, Times::class.java)
            startActivity(intent)
            finish()
        }

        // 後面への切り替え
        val change_button = findViewById<Button>(R.id.change_back)
        change_button.setOnClickListener {
            startActivity(Intent(this, TrainedBack::class.java))
        }

        //　右腕の状態疲労度入力
        var rightArm = findViewById<Button>(R.id.right_arm)
        rightArm.setBackgroundColor(checkCol[if (trainedArea[0]) 1 else 0])
        rightArm.setOnClickListener {
            trainedArea[0] = !trainedArea[0]
            rightArm.setBackgroundColor(checkCol[if (trainedArea[0]) 1 else 0])
        }

        var leftArm = findViewById<Button>(R.id.left_arm)
        leftArm.setBackgroundColor(checkCol[if (trainedArea[1]) 1 else 0])
        leftArm.setOnClickListener {
            trainedArea[1] = !trainedArea[1]
            leftArm.setBackgroundColor(checkCol[if (trainedArea[1]) 1 else 0])
        }

        var chest = findViewById<Button>(R.id.chest)
        chest.setBackgroundColor(checkCol[if (trainedArea[2]) 1 else 0])
        chest.setOnClickListener {
            trainedArea[2] = !trainedArea[2]
            chest.setBackgroundColor(checkCol[if (trainedArea[2]) 1 else 0])
        }
        var stomach = findViewById<Button>(R.id.stomach)
        stomach.setBackgroundColor(checkCol[if (trainedArea[3]) 1 else 0])
        stomach.setOnClickListener {
            trainedArea[3] = !trainedArea[3]
            stomach.setBackgroundColor(checkCol[if (trainedArea[3]) 1 else 0])
        }
        var rightLeg = findViewById<Button>(R.id.right_leg)
        rightLeg.setBackgroundColor(checkCol[if (trainedArea[4]) 1 else 0])
        rightLeg.setOnClickListener {
            trainedArea[4] = !trainedArea[4]
            rightLeg.setBackgroundColor(checkCol[if (trainedArea[4]) 1 else 0])
        }
        var leftLeg = findViewById<Button>(R.id.left_leg)
        leftLeg.setBackgroundColor(checkCol[if (trainedArea[5]) 1 else 0])
        leftLeg.setOnClickListener {
            trainedArea[5] = !trainedArea[5]
            leftLeg.setBackgroundColor(checkCol[if (trainedArea[5]) 1 else 0])
        }
    }
}

class TrainedBack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trained_back)

        //次画面への遷移ボタン
        val button = findViewById<Button>(R.id.tra_com_back)
        button.setOnClickListener {
            adMe.getArea(trainedArea)//筋トレしたい部位を取得
            val intent = Intent(this, Times::class.java)
            startActivity(intent)
            finish()
        }
        //前面への切り替え
        val change_button = findViewById<Button>(R.id.change_front)
        change_button.setOnClickListener {
            startActivity(Intent(this, Trained::class.java))
        }

        var back = findViewById<Button>(R.id.back)
        back.setBackgroundColor(checkCol[if (trainedArea[6]) 1 else 0])
        back.setOnClickListener {
            trainedArea[6] = !trainedArea[6]
            back.setBackgroundColor(checkCol[if (trainedArea[6]) 1 else 0])
        }
        var rightcalf = findViewById<Button>(R.id.right_calf)
        rightcalf.setBackgroundColor(checkCol[if (trainedArea[7]) 1 else 0])
        rightcalf.setOnClickListener {
            trainedArea[7] = !trainedArea[7]
            rightcalf.setBackgroundColor(checkCol[if (trainedArea[7]) 1 else 0])
        }
        var leftcalf = findViewById<Button>(R.id.left_calf)
        leftcalf.setBackgroundColor(checkCol[if (trainedArea[8]) 1 else 0])
        leftcalf.setOnClickListener {
            trainedArea[8] = !trainedArea[8]
            leftcalf.setBackgroundColor(checkCol[if (trainedArea[8]) 1 else 0])
        }
    }
}