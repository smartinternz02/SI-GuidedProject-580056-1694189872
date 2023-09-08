package com.example.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : ComponentActivity() {
    private lateinit var diceImage: ImageView
    private lateinit var resultTextView: TextView
    private lateinit var rollButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
        rollButton = findViewById(R.id.rollButton)
        diceImage = findViewById(R.id.diceImage)
        rollButton.setOnClickListener{
            rollDice()
        }
    }

private fun rollDice() {
    val random= Random()
    val randomNumber=random.nextInt(6)+1
    val drawableResource = when (randomNumber) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        else -> R.drawable.dice6
    }
    diceImage.setImageResource(drawableResource)
    resultTextView.text= "you rolled a $randomNumber"
}
}
