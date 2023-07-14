package _18주차.두_원_사이의_정수_쌍

import kotlin.math.ceil
import kotlin.math.floor
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

    val r11 = 2
    val r21 = 3
    val answer1 = 20L
    val result1 = Solution().solution(r11, r21)
    printResult(1, result1, answer1)
}


class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0
        for (i in 1..r2) {
            val start = ceil(sqrt((r1.toLong() * r1 - i.toLong() * i).toDouble())).toInt()
            val end = floor(sqrt((r2.toLong() * r2 - i.toLong() * i).toDouble())).toInt()
            answer += (end - start + 1).toLong()
        }
        return answer * 4
    }
}