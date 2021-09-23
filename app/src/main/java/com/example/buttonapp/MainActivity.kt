package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {

    lateinit var counter: TextView
    lateinit var increaseButton: Button
    lateinit var decreaseButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        counter = findViewById(R.id.counter)
        increaseButton = findViewById(R.id.increase)
        decreaseButton = findViewById(R.id.decrease)

        increaseButton.setOnClickListener { increase() }
        decreaseButton.setOnClickListener { decrease() }

    }

    fun increase(){
        counter.text = (counter.text.toString().toInt() + 1).toString()
        changColor(counter.text.toString().toInt(), counter)
        changeMargin(counter.text.toString().toInt(), counter)
    }
    fun decrease(){
        counter.text = (counter.text.toString().toInt() - 1).toString()
        changColor(counter.text.toString().toInt(), counter)
        changeMargin(counter.text.toString().toInt(), counter)
    }

    fun changColor(number: Int, text: TextView) {
        when{
            number == 0 -> text.setTextColor(Color.BLACK)
            number > 0 -> text.setTextColor(Color.GREEN)
            else -> text.setTextColor(Color.RED)
        }
    }

    fun changeMargin(number: Int, text: TextView){
        // set text view layout margin programmatically
        // https://android--code.blogspot.com/2020/07/android-kotlin-textview-margin.html
        (text.layoutParams as ConstraintLayout.LayoutParams).apply {
            bottomMargin = number*10
        }
    }

}