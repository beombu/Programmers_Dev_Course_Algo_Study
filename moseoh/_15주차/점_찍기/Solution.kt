package _15주차.점_찍기

import kotlin.math.pow
import kotlin.math.sqrt

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

    val k1 = 2
    val d1 = 4
    val answer1 = 6L
    val result1 = Solution().solution(k1, d1)
    printResult(1, result1, answer1)

    val k2 = 1
    val d2 = 5
    val answer2 = 26L
    val result2 = Solution().solution(k2, d2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0
        for (i in 0..d step k) {
            answer += (sqrt(d.toDouble().pow(2.0) - i.toDouble().pow(2.0)).toInt() / k + 1)
        }
        return answer
    }
}