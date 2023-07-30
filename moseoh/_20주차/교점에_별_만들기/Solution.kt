package _20주차.교점에_별_만들기

import kotlin.math.max
import kotlin.math.min

fun main() {
    fun printResult(index: Int, result: Array<String>, answer: Array<String>) {
        val correct = result.contentEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val line1 = arrayOf(
        intArrayOf(2, -1, 4),
        intArrayOf(-2, -1, 4),
        intArrayOf(0, -1, 1),
        intArrayOf(5, -8, -12),
        intArrayOf(5, 8, 12)
    )
    val answer1 = arrayOf(
        "....*....",
        ".........",
        ".........",
        "*.......*",
        ".........",
        ".........",
        ".........",
        ".........",
        "*.......*"
    )
    val result1 = Solution().solution(line1)
    printResult(1, result1, answer1)

    val line2 = arrayOf(intArrayOf(0, 1, -1), intArrayOf(1, 0, -1), intArrayOf(1, 0, 1))
    val answer2 = arrayOf("*.*")
    val result2 = Solution().solution(line2)
    printResult(2, result2, answer2)

    val line3 = arrayOf(intArrayOf(1, -1, 0), intArrayOf(2, -1, 0))
    val answer3 = arrayOf("*")
    val result3 = Solution().solution(line3)
    printResult(3, result3, answer3)

    val line4 = arrayOf(intArrayOf(1, -1, 0), intArrayOf(2, -1, 0), intArrayOf(4, -1, 0))
    val answer4 = arrayOf("*")
    val result4 = Solution().solution(line4)
    printResult(4, result4, answer4)
}

class Solution {
    fun solution(line: Array<IntArray>): Array<String> {
        val list = mutableListOf<Point>()
        var minX = Long.MAX_VALUE
        var maxX = Long.MIN_VALUE
        var minY = Long.MAX_VALUE
        var maxY = Long.MIN_VALUE

        for (i in line.indices) {
            val equation1 = Equation(line[i])
            for (j in i + 1 until line.size) {
                val equation2 = Equation(line[j])

                val denominator = equation1.getDenominator(equation2)
                if (denominator == 0L) continue

                val xNumerator = equation1.getXNumerator(equation2)
                val yNumerator = equation1.getYNumerator(equation2)
                if (xNumerator % denominator != 0L || yNumerator % denominator != 0L) continue

                list.add(Point(xNumerator / denominator, yNumerator / denominator))
                minX = min(minX, list.last().x)
                minY = min(minY, list.last().y)
                maxX = max(maxX, list.last().x)
                maxY = max(maxY, list.last().y)
            }
        }

        val height = (maxY - minY + 1)
        val width = (maxX - minX + 1)

        val answer = Array(height.toInt()) { "" }
        val board = Array(height.toInt()) { BooleanArray(width.toInt()) }

        for ((x1, y1) in list) {
            val x = (x1 - minX).toInt()
            val y = (maxY - y1).toInt()
            board[y][x] = true
        }
        for ((i, booleans) in board.withIndex()) {
            val sb = java.lang.StringBuilder()
            for (b in booleans) {
                if (b) {
                    sb.append("*")
                } else {
                    sb.append(".")
                }
            }
            answer[i] = sb.toString()
        }

        return answer
    }

    data class Equation(
        val x: Long,
        val y: Long,
        val c: Long,
    ) {
        constructor(intArray: IntArray) : this(
            intArray[0].toLong(),
            intArray[1].toLong(),
            intArray[2].toLong(),
        )

        fun getDenominator(equation: Equation): Long {
            return this.x * equation.y - equation.x * this.y
        }

        fun getXNumerator(equation: Equation): Long {
            return this.y * equation.c - this.c * equation.y
        }

        fun getYNumerator(equation: Equation): Long {
            return this.c * equation.x - this.x * equation.c
        }
    }

    data class Point(
        val x: Long,
        val y: Long,
    )
}
