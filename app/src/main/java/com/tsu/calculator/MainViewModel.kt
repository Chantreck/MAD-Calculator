package com.tsu.calculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.abs
import kotlin.math.floor

class MainViewModel : ViewModel() {
    private var commaAdded = false

    private var _firstOperand: String = ""
    private var _secondOperand: String = ""
    private var _operation: String? = null

    private var _display = MutableLiveData<String>()
    val display: LiveData<String> get() = _display

    init {
        clear()
    }

    fun action(button: Buttons) {

    }

    fun addNumber(number: String) {
        val length = _secondOperand.length
        if (length >= 9) {
            return
        }

        if (_secondOperand.isEmpty()) {
            if (number == ".") {
                _secondOperand = "0."
                commaAdded = true
            } else {
                _secondOperand = number
            }
        } else {
            if (number == "." && commaAdded) {
                return
            }
            if (number == ".") {
                commaAdded = true
            }
            _secondOperand += number
        }

        prepareDisplayValue(_secondOperand)
    }

    private fun clearSecondOperand() {
        commaAdded = false
        _secondOperand = ""
    }

    fun clear() {
        _firstOperand = ""
        clearSecondOperand()

        _operation = null
        prepareDisplayValue("0")
    }

    fun setOperation(operation: String) {
        if (_firstOperand.isEmpty() && _secondOperand.isEmpty()) {
            _firstOperand = "0"
        }

        if (operation == "percent") {
            getPercentage()
        }

        if (_secondOperand.isNotEmpty()) {
            getResult()
        }
        _operation = operation
    }

    private fun getPercentage() {
        val number: String = when {
            _firstOperand.isNotEmpty() -> {
                _firstOperand
            }
            _secondOperand.isNotEmpty() -> {
                _secondOperand
            }
            else -> {
                return
            }
        }

        val result = MainModel.calculatePercent(number.toDouble())
        _firstOperand = result.toString()
        prepareDisplayValue(_firstOperand)
        clearSecondOperand()
        return
    }

    fun getResult() {
        val operation = _operation
        if (operation == null) {
            if (_firstOperand.isEmpty()) {
                _firstOperand = _secondOperand
                clearSecondOperand()
                return
            } else {
                clear()
                prepareDisplayValue("Error")
                return
            }
        }

        if (_firstOperand.isNotEmpty() && _secondOperand.isNotEmpty()) {
            val firstNumber = _firstOperand.toDouble()
            val secondNumber = _secondOperand.toDouble()

            try {
                val result = MainModel.calculate(firstNumber, secondNumber, operation)
                _firstOperand = result.toString()
                prepareDisplayValue(result.toString())
                clearSecondOperand()

                Log.d("Test", "$firstNumber $operation $secondNumber = $result")
            } catch (e: Exception) {
                clear()
                prepareDisplayValue("Error")

                Log.e("Test", e.message.toString())
            }

            return
        }

        _firstOperand = _secondOperand
        clearSecondOperand()
    }

    fun changeSign() {
        if ((_secondOperand.isEmpty() || _secondOperand == "0") &&
            (_firstOperand.isEmpty() || _firstOperand == "0")
        ) {
            return
        }

        if (_secondOperand.isEmpty() || _secondOperand == "0") {
            if (_firstOperand[0] == '-') {
                _firstOperand = _firstOperand.drop(1)
            } else {
                _firstOperand = "-" + _firstOperand
            }
            prepareDisplayValue(_firstOperand)
        } else {
            if (_secondOperand[0] == '-') {
                _secondOperand = _secondOperand.drop(1)
            } else {
                _secondOperand = "-" + _secondOperand
            }
            prepareDisplayValue(_secondOperand)
        }
    }

    private fun prepareDisplayValue(value: String) {
        var result = value

        if (result.endsWith(".0")) {
            result = result.dropLast(2)
        }

        if (result.length > 9) {
            _display.value = String.format("%.5E", result.toDouble())
        } else {
            _display.value = result
        }
    }
}