package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Declare visual components
    private lateinit var tvMessage: TextView
    private lateinit var btnClickMe: Button

    // Declare attributes
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvMessage = findViewById<TextView>(R.id.tvMessage)
        tvMessage.text = "Hola mundo"
        btnClickMe = findViewById<Button>(R.id.btnClickMe)
        btnClickMe.setOnClickListener {
            this.handleClick()

        }
    }

    private fun handleClick() {
        counter++
        tvMessage.text = "Hola mundo: " + counter
    }
}