package com.example.biggernumbertest

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButtons()
        btnLeft.setOnClickListener {
            checkAnswer(true)
        }

        btnRight.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun checkAnswer(isLeftButtonClicked: Boolean) {
        // code here will run, when the btnLeft is clicked
        // 1. Compare the numebrs in btnLeft and btnRight
        val leftNum: Int = btnLeft.text.toString().toInt()
        val rightNum: Int = btnRight.text.toString().toInt()
        val isAnswerCorrect: Boolean = if (isLeftButtonClicked) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            // Correct Answer!!
            // 1. Change background color
            backgroundView.setBackgroundColor(Color.GREEN)
            // 2. Show a toast
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }


        // 2. Pick new random numbers
        assignNumbersToButtons()
    }

    private fun assignNumbersToButtons() {
        val r = Random()
        val leftNum: Int = r.nextInt(10)
        var rightNum = leftNum
        while (leftNum == rightNum) {
            rightNum = r.nextInt(10)
        }
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }
}