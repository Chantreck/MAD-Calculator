package com.tsu.calculator

import android.util.Log

class MainModel {
    private var commaAdded = false

    private var _firstOperand: String = ""
    private var _secondOperand: String = ""
    private var _operation: Buttons? = null

    companion object {
        const val MAX_LENGTH = 10
        private const val DIVISION_ERROR = "Division by zero"
        private const val OPERATOR_ERROR = "Unknown operator"
        private const val ERROR = "Error"
    }

    private fun calculate(first: Double, second: Double, operator: Buttons): Double {
        val result: Double

        when (operator) {
            Buttons.DIVIDE -> {
                if (second.equals(0.0)) {
                    throw Exception(DIVISION_ERROR)
                } else {
                    result = first.div(second)
                }
            }
            Buttons.MULTIPLY -> {
                result = first * second
            }
            Buttons.MINUS -> {
                result = first - second
            }
            Buttons.PLUS -> {
                result = first + second
            }
            else -> {
                Log.e("Model", OPERATOR_ERROR + " " + operator.label)
                throw Exception(OPERATOR_ERROR)
            }
        }

        return result
    }

    fun getResult(): String {
        val operation = _operation
        if (operation == null) {
            if (_firstOperand.isEmpty()) {
                _firstOperand = _secondOperand
                clearSecondOperand()
                return ""
            } else {
                clear()
                return ERROR
            }
        }

        if (_firstOperand.isNotEmpty() && _secondOperand.isNotEmpty()) {
            val firstNumber = _firstOperand.toDouble()
            val secondNumber = _secondOperand.toDouble()

            try {
                val result = calculate(firstNumber, secondNumber, operation)
                _firstOperand = result.toString()
                clearSecondOperand()
                return result.toString()
            } catch (e: Exception) {
                clear()
                return ERROR
            }
        }

        _firstOperand = _secondOperand
        clearSecondOperand()
        return ""
    }

    fun setOperation(operation: Buttons): String {
        if (_firstOperand.isEmpty() && _secondOperand.isEmpty()) {
            _firstOperand = "0"
        }

        if (_secondOperand.isNotEmpty()) {
            val result = getResult()
            _operation = operation
            return result
        }

        _operation = operation
        return ""
    }

    private fun clearSecondOperand() {
        commaAdded = false
        _secondOperand = ""
    }

    fun clear() {
        _firstOperand = ""
        clearSecondOperand()
        _operation = null
    }

    fun changeSign(): String {
        if ((_secondOperand.isEmpty() || _secondOperand == "0") &&
            (_firstOperand.isEmpty() || _firstOperand == "0")
        ) {
            return ""
        }

        if (_secondOperand.isEmpty() || _secondOperand == "0") {
            if (_firstOperand[0] == '-') {
                _firstOperand = _firstOperand.drop(1)
            } else {
                _firstOperand = "-$_firstOperand"
            }
            return _firstOperand
        }

        if (_secondOperand[0] == '-') {
            _secondOperand = _secondOperand.drop(1)
        } else {
            _secondOperand = "-$_secondOperand"
        }
        return _secondOperand
    }

    fun addNumber(number: String): String {
        val length = _secondOperand.length
        if (length >= MAX_LENGTH - 2) {
            return ""
        }

        if (_secondOperand.isEmpty() || (_secondOperand == "0" && number == "0")) {
            _secondOperand = number
        } else {
            _secondOperand += number
        }

        return _secondOperand
    }

    fun addComma(): String {
        val length = _secondOperand.length
        if (length >= MAX_LENGTH - 2) {
            return ""
        }

        if (_secondOperand.isEmpty()) {
            _secondOperand = "0."
            commaAdded = true
        } else {
            if (commaAdded) {
                return ""
            }
            _secondOperand += "."
            commaAdded = true
        }

        return _secondOperand
    }

    fun getPercentage(): String {
        val number: String = when {
            _firstOperand.isNotEmpty() -> {
                _firstOperand
            }
            _secondOperand.isNotEmpty() -> {
                _secondOperand
            }
            else -> {
                return ""
            }
        }

        val result = number.toDouble() / 100.0
        _firstOperand = result.toString()
        clearSecondOperand()

        return _firstOperand
    }
}