package me.parker.nextstep.kotlinracingcar.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @Test
    fun `두 수의 더하기 계산`() {
        val result = Calculator.calculate("1+2")

        assertThat(result).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = [" 1 + 2 ", "  1 +     2 "])
    fun `두 수의 더하기 계산 - 공백을 포함한 문자열 입력`(input: String) {
        val result = Calculator.calculate(input)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `두 수의 빼기 계산`() {
        val result = Calculator.calculate("1-2")

        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `두 수의 곱하기 계산`() {
        val result = Calculator.calculate("1*2")

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `두 수의 나누기 계산`() {
        val result = Calculator.calculate("1/2")

        assertThat(result).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["2 + 3 * 4 / 2=10", "2 - 10 / 4=-2", "200-100*30/10=300"],
        delimiter = '='
    )
    fun `세 개 이상의 인자 계산`(input: String, expected: String) {
        val result = Calculator.calculate(input)

        assertThat(result).isEqualTo(expected.toInt())
    }

    @ParameterizedTest
    @EmptySource
    fun `입력값이 비어있는 경우 예외 발생`(input: String) {
        assertThatThrownBy { Calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값이 비어있습니다.")
    }
}