package me.parker.nextstep.kotlinracingcar.calculator

enum class OperatorType(val symbol: String, val calculate: (Int, Int) -> Int) {
    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun calculate(operator: String, lValue: Int, rValue: Int): Int {
            return when (operator) {
                ADD.symbol -> ADD.calculate(lValue, rValue)
                SUBTRACT.symbol -> SUBTRACT.calculate(lValue, rValue)
                MULTIPLY.symbol -> MULTIPLY.calculate(lValue, rValue)
                DIVIDE.symbol -> DIVIDE.calculate(lValue, rValue)
                else -> throw IllegalArgumentException("올바르지 않은 연산자입니다.")
            }
        }

        fun of(operator: String): Boolean {
            return values().any { it.symbol == operator }
        }
    }
}