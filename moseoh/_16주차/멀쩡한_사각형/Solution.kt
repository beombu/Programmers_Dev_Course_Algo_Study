package _16주차.멀쩡한_사각형

import java.math.BigInteger

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

    val w1 = 8
    val h1 = 7
    val answer1 = 80L
    val result1 = Solution().solution(w1, h1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(w: Int, h: Int): Long {
        val a = BigInteger.valueOf(w.toLong())
        val b = BigInteger.valueOf(h.toLong())
        val gcd = a.gcd(b)
        val cW = w / gcd.toInt()
        val cH = h / gcd.toInt()
        return (cW * gcd.toInt()).toLong() * (cH * gcd.toInt()) - (cW + cH - 1) * gcd.toInt()
    }
}