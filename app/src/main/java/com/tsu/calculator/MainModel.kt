package com.tsu.calculator

object MainModel {
    fun calculatePercent(first: Double): Double {
        return first / 100.0
    }

    fun calculate(first: Double, second: Double, operator: String): Double {
        val result: Double

        when (operator) {
            "divide" -> {
                if (second.equals(0.0)) {
                    throw Exception("Division by zero")
                } else {
                    result = first.div(second)
                }
            }
            "multiply" -> {
                result = first * second
            }
            "subtract" -> {
                result = first - second
            }
            "add" -> {
                result = first + second
            }
            else -> {
                throw Exception("Unknown operator")
            }
        }

        return result
    }
}