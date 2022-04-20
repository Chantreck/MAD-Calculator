package com.tsu.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val model = MainModel()

    private var _display = MutableLiveData<String>()
    val display: LiveData<String> get() = _display

    init {
        clear()
    }

    fun action(button: Buttons) {
        val result: String
        when (button) {
            Buttons.CLEAR -> {
                model.clear()
                result = "0"
            }
            Buttons.PLUS_MINUS -> {
                result = model.changeSign()
            }
            Buttons.PERCENT -> {
                result = model.getPercentage()
            }
            Buttons.DIVIDE, Buttons.MULTIPLY, Buttons.MINUS, Buttons.PLUS -> {
                var temp = model.setOperation(button)
                if (temp.endsWith(".0")) {
                    temp = temp.dropLast(2)
                }
                result = temp
            }
            Buttons.EQUAL -> {
                var temp = model.getResult()
                if (temp.endsWith(".0")) {
                    temp = temp.dropLast(2)
                }
                result = temp
            }
            Buttons.COMMA -> {
                result = model.addComma()
            }
            else -> {
                result = model.addNumber(button.label)
            }
        }
        prepareDisplayValue(result)
    }

    private fun clear() {
        model.clear()
        prepareDisplayValue("0")
    }

    private fun prepareDisplayValue(value: String) {
        if (value.isEmpty()) {
            return
        }

        if (value.length > MainModel.MAX_LENGTH) {
            _display.value = String.format("%.5E", value.toDouble())
        } else {
            _display.value = value
        }
    }
}