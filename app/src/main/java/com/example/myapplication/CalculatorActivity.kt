package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

enum class State {
    INIT,
    FIRSTFIGURE,
    SECONDFIGURE,
    RESULT
}

class CalculatorActivity : AppCompatActivity() {
    var btnArrayList = ArrayList<Button>()
    var tvDisplay: TextView? = null
    var calculatorEngine = Calculator();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        this.bringComponents()
    }

    private fun processNumber(number: Int) {
        this.tvDisplay?.text = this.calculatorEngine.processNumber(number)
    }

    private fun processSymbol(operator: String) {
        this.tvDisplay?.text = this.calculatorEngine.processSymbol(operator)
    }


    private fun bringComponents(){
        tvDisplay = findViewById<TextView>(R.id.textview_display)
        var btn0: Button  = findViewById<Button>(R.id.button0)
        var btn1: Button = findViewById<Button>(R.id.button1)
        var btn2: Button = findViewById<Button>(R.id.button2)
        var btn3: Button = findViewById<Button>(R.id.button3)
        var btn4: Button = findViewById<Button>(R.id.button4)
        var btn5: Button = findViewById<Button>(R.id.button5)
        var btn6: Button = findViewById<Button>(R.id.button6)
        var btn7: Button = findViewById<Button>(R.id.button7)
        var btn8: Button = findViewById<Button>(R.id.button8)
        var btn9: Button = findViewById<Button>(R.id.button9)
        var btnPlus: Button = findViewById<Button>(R.id.button_plus)
        var btnMinus: Button = findViewById<Button>(R.id.button_minus)
        var btnMultiply: Button = findViewById<Button>(R.id.button_multiply)
        var btnDivide: Button = findViewById<Button>(R.id.button_divide)
        var btnEqual: Button = findViewById<Button>(R.id.button_equal)
        this.btnArrayList.add(btn0)
        this.btnArrayList.add(btn1)
        this.btnArrayList.add(btn2)
        this.btnArrayList.add(btn3)
        this.btnArrayList.add(btn4)
        this.btnArrayList.add(btn5)
        this.btnArrayList.add(btn6)
        this.btnArrayList.add(btn7)
        this.btnArrayList.add(btn8)
        this.btnArrayList.add(btn9)
        this.btnArrayList.add(btnPlus)
        this.btnArrayList.add(btnMinus)
        this.btnArrayList.add(btnMultiply)
        this.btnArrayList.add(btnDivide)
        this.btnArrayList.add(btnEqual)
        for (btn in this.btnArrayList) {
            btn.setOnClickListener {

                var id = btn.id
                when (id) {
                    R.id.button0 -> {
                        this.processNumber(0)
                    }
                    R.id.button1 -> {
                        this.processNumber(1)
                    }
                    R.id.button2 -> {
                        this.processNumber(2)
                    }
                    R.id.button3 -> {
                        this.processNumber(3)
                    }
                    R.id.button4 -> {
                        this.processNumber(4)
                    }
                    R.id.button5 -> {
                        this.processNumber(5)
                    }
                    R.id.button6 -> {
                        this.processNumber(6)
                    }
                    R.id.button7 -> {
                        this.processNumber(7)
                    }
                    R.id.button8 -> {
                        this.processNumber(8)
                    }
                    R.id.button9 -> {
                        this.processNumber(9)
                    }
                    R.id.button_plus -> {
                        this.processSymbol("+")
                    }
                    R.id.button_minus -> {
                        this.processSymbol("-")
                    }
                    R.id.button_multiply -> {
                        this.processSymbol("*")
                    }
                    R.id.button_divide -> {
                        this.processSymbol("/")
                    }
                    R.id.button_equal -> {
                        this.processSymbol("=")
                    }
                }

            }
        }
    }
}