package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_button: Button = findViewById<Button>(R.id.roll_button)
        btn_button.setOnClickListener { rollDice() }


    }

    fun rollDice(){
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)

        resultText.text = randomInt.toString()

        Toast.makeText(this,"Button clicked", Toast.LENGTH_SHORT).show()

    }
}