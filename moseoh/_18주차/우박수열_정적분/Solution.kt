package _18주차.우박수열_정적분

import kotlin.math.max
import kotlin.math.min

fun main() {
    fun printResult(index: Int, result: DoubleArray, answer: DoubleArray) {
        val correct = result.contentEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val k1 = 10
    val ranges1 = arrayOf(intArrayOf(0, 0), intArrayOf(0, -1), intArrayOf(2, -3), intArrayOf(3, -3))
    val answer1 = doubleArrayOf(33.0, 31.5, 0.0, -1.0)
    val result1 = Solution().solution(k1, ranges1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        val hailStone = getHailStone(k)
        val area = getArea(hailStone)
        return ranges.map { getIntegral(area, it, area.size - 1) }.toDoubleArray()
    }

    private fun getIntegral(area: List<Double>, range: IntArray, length: Int): Double {
        val startIndex = range[0]
        val endIndex = length + range[1]
        if (startIndex == endIndex) return 0.0
        if (startIndex > endIndex) return -1.0
        return area[endIndex] - area[startIndex]
    }

    private fun getArea(hailStone: List<Int>): List<Double> {
        val area = mutableListOf<Double>()
        area.add(0.0)

        for (i in 0 until hailStone.size - 1) {
            val min = min(hailStone[i], hailStone[i + 1])
            val max = max(hailStone[i], hailStone[i + 1])
            area.add(min + ((max - min).toDouble() / 2) + area[i])
        }
        return area
    }

    private fun getHailStone(k: Int): List<Int> {
        val hailStone = mutableListOf<Int>()
        var num = k
        while (num != 1) {
            hailStone.add(num)
            num = if (num % 2 == 0) num / 2 else num * 3 + 1
        }

        hailStone.add(1)
        return hailStone
    }
}