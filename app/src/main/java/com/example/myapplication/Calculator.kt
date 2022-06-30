package com.example.myapplication

class Calculator {
    var currentState = State.INIT
    var firstNumber = 0
    var secondNumber = 0
    var resultNumber = 0
    var operator = ""

    var display = ""

    fun processNumber(number: Int): String {
//        this.display = this.display.toString() + number
        when (currentState) {
            State.INIT -> {
                this.firstNumber = number
                this.display = number.toString()
                currentState = State.FIRSTFIGURE
            }
            State.FIRSTFIGURE -> {
                this.display = this.display.toString() + number
                this.firstNumber = this.firstNumber * 10 + number
            }
            State.SECONDFIGURE -> {
                this.display = this.display.toString() + number
                this.secondNumber = this.secondNumber * 10 + number
            }
            State.RESULT -> {
                this.firstNumber = number
                this.secondNumber = 0
                this.resultNumber = 0
                this.operator = ""
                this.display = number.toString()
                currentState = State.FIRSTFIGURE
            }
        }

        return this.display
    }

    fun processSymbol(symbol: String): String {
//        this.display = this.display.toString() + symbol
        when(currentState) {
            State.INIT -> {
            }
            State.FIRSTFIGURE -> {
                if(symbol == "+" || symbol == "-" || symbol == "*" || symbol == "/") {
                    this.operator = symbol
                    this.display = this.display.toString() + symbol
                    this.currentState = State.SECONDFIGURE
                }
            }
            State.SECONDFIGURE -> {
                if(symbol == "="){
                    this.resultNumber = resolve()
                    this.display = this.display.toString() + symbol + this.resultNumber.toString()
                    this.currentState = State.RESULT
                }
            }
            State.RESULT -> {
                if(symbol == "+" || symbol == "-" || symbol == "*" || symbol == "/") {
                    this.operator = symbol
                    this.firstNumber = this.resultNumber
                    this.secondNumber = 0
                    this.resultNumber = 0
                    this.display = this.firstNumber.toString() + symbol
                    this.currentState = State.SECONDFIGURE
                }

            }
        }
        return this.display
    }

    private fun resolve(): Int {
        when(this.operator) {
            "+" -> return this.firstNumber + this.secondNumber
            "-" -> return this.firstNumber - this.secondNumber
            "*" -> return this.firstNumber * this.secondNumber
            "/" -> return this.firstNumber / this.secondNumber
        }
        return 0
    }


}