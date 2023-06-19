package _15주차.카카오_인턴_수식_최대화

import kotlin.math.abs
import kotlin.math.max

fun main() {
    fun printResult(index: Int, result: Long, answer: Long) {
        val correct = result == answer
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val expression1 = "100-200*300-500+20"
    val answer1 = 60420L
    val result1 = Solution().solution(expression1)
    printResult(1, result1, answer1)

    val expression2 = "50*6-3*2"
    val answer2 = 300L
    val result2 = Solution().solution(expression2)
    printResult(2, result2, answer2)
}


class Solution {

    private val operationRanks = arrayOf(
        charArrayOf('*', '+', '-'),
        charArrayOf('*', '-', '+'),
        charArrayOf('+', '*', '-'),
        charArrayOf('+', '-', '*'),
        charArrayOf('-', '*', '+'),
        charArrayOf('-', '+', '*'),
    )

    fun solution(expression: String): Long {
        val numbers = expression.split(Regex("[*+-]")).map { it.toLong() }
        val operations = expression.filter { it in "*+-" }.toList()
        var result = Long.MIN_VALUE

        for (operationRank in operationRanks) {
            result = max(result, getExpressionResult(operationRank, numbers, operations))
        }

        return result
    }

    private fun getExpressionResult(operationRank: CharArray, numbers: List<Long>, operations: List<Char>): Long {
        val numberList = numbers.toMutableList()
        val operationList = operations.toMutableList()

        for (operation in operationRank) {
            while (numberList.size > 1) {
                val index = operationList.indexOf(operation)
                if (index == -1) break;

                val num1 = numberList.pop(index)
                val num2 = numberList.pop(index)
                operationList.removeAt(index)
                numberList.add(index, calc(num1, num2, operation))
            }
        }
        return abs(numberList[0])
    }

    private fun MutableList<Long>.pop(index: Int): Long {
        val number = this[index]
        this.removeAt(index)
        return number
    }

    private fun calc(num1: Long, num2: Long, operation: Char): Long {
        return when (operation) {
            '-' -> num1 - num2
            '+' -> num1 + num2
            '*' -> num1 * num2
            else -> throw RuntimeException()
        }
    }
}