package com.tsu.calculator

import timber.log.Timber

class MainModel {
    companion object {
        const val MAX_LENGTH = 10
        private const val DIVISION_ERROR = "Division by zero"
        private const val OPERATOR_ERROR = "Unknown operator"
        private const val ERROR = "Error"
        private const val INITIAL_VALUE = "0"
        private const val EMPTY = ""
        private const val COMMA_SIGN = "."
    }

    private var commaAdded = false
    private var firstOperand: String = ""
    private var secondOperand: String = ""
    private var operation: Buttons = Buttons.NO_OPERATION

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
                Timber.e("$OPERATOR_ERROR: ${operator.label}")
                throw Exception(OPERATOR_ERROR)
            }
        }

        return result
    }

    fun getResult(): String {
        if (operation == Buttons.NO_OPERATION) {
            if (firstOperand.isEmpty()) {
                firstOperand = secondOperand
                clearSecondOperand()
                return EMPTY
            } else {
                clear()
                return ERROR
            }
        }

        if (firstOperand.isNotEmpty() && secondOperand.isNotEmpty()) {
            val firstNumber = firstOperand.toDouble()
            val secondNumber = secondOperand.toDouble()

            try {
                val result = calculate(firstNumber, secondNumber, operation)
                firstOperand = result.toString()
                clearSecondOperand()
                return firstOperand
            } catch (e: Exception) {
                clear()
                return ERROR
            }
        }

        firstOperand = secondOperand
        clearSecondOperand()
        return EMPTY
    }

    fun setOperation(operation: Buttons): String {
        if (firstOperand.isEmpty() && secondOperand.isEmpty()) {
            firstOperand = INITIAL_VALUE
        }

        if (secondOperand.isNotEmpty()) {
            val result = getResult()
            this.operation = operation
            return result
        }

        this.operation = operation
        return EMPTY
    }

    private fun clearSecondOperand() {
        commaAdded = false
        secondOperand = EMPTY
    }

    fun clear() {
        firstOperand = EMPTY
        clearSecondOperand()
        operation = Buttons.NO_OPERATION
    }

    fun changeSign(): String {
        if ((secondOperand.isEmpty() || secondOperand == INITIAL_VALUE) &&
            (firstOperand.isEmpty() || firstOperand == INITIAL_VALUE)
        ) {
            return ""
        }

        //TODO change logic in order not to compare strings

        if (secondOperand.isEmpty() || secondOperand == INITIAL_VALUE) {
            if (firstOperand[0].toString() == Buttons.MINUS.label) {
                firstOperand = firstOperand.drop(1)
            } else {
                firstOperand = "-$firstOperand"
            }
            return firstOperand
        }

        if (secondOperand[0].toString() == Buttons.MINUS.label) {
            secondOperand = secondOperand.drop(1)
        } else {
            secondOperand = "-$secondOperand"
        }
        return secondOperand
    }

    fun addNumber(number: String): String {
        val length = secondOperand.length
        if (length >= MAX_LENGTH - 2) {
            return ""
        }

        if (secondOperand.isEmpty() || (secondOperand == INITIAL_VALUE && number == INITIAL_VALUE)) {
            secondOperand = number
        } else {
            secondOperand += number
        }

        return secondOperand
    }

    fun addComma(): String {
        val length = secondOperand.length
        if (length >= MAX_LENGTH - 2) {
            return EMPTY
        }

        if (secondOperand.isEmpty()) {
            commaAdded = true
            secondOperand = INITIAL_VALUE + COMMA_SIGN
            return secondOperand
        }

        if (commaAdded) {
            return EMPTY
        }

        commaAdded = true
        secondOperand += COMMA_SIGN
        return secondOperand
    }

    fun getPercentage(): String {
        val number: String = when {
            firstOperand.isNotEmpty() -> {
                firstOperand
            }
            secondOperand.isNotEmpty() -> {
                secondOperand
            }
            else -> {
                return EMPTY
            }
        }

        val result = number.toDouble() / 100.0
        firstOperand = result.toString()
        clearSecondOperand()

        return firstOperand
    }
}