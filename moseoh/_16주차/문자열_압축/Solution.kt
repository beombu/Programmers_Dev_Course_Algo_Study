package _16주차.문자열_압축

import kotlin.math.min

fun main() {
    fun printResult(index: Int, result: Int, answer: Int) {
        val correct = result == answer
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val s1 = "aabbaccc"
    val answer1 = 7
    val result1 = Solution().solution(s1)
    printResult(1, result1, answer1)

    val s2 = "ababcdcdababcdcd"
    val answer2 = 9
    val result2 = Solution().solution(s2)
    printResult(2, result2, answer2)

    val s3 = "abcabcdede"
    val answer3 = 8
    val result3 = Solution().solution(s3)
    printResult(3, result3, answer3)

    val s4 = "abcabcabcabcdededededede"
    val answer4 = 14
    val result4 = Solution().solution(s4)
    printResult(4, result4, answer4)

    val s5 = "xababcdcdababcdcd"
    val answer5 = 17
    val result5 = Solution().solution(s5)
    printResult(5, result5, answer5)
}

class Solution {
    fun solution(s: String): Int {
        var answer = 0
        for (i in 1..s.length / 2 + 1) {
            val result = compressedString(s, i, 1).length
            answer = if (i == 1) result else min(answer, result)
        }
        return answer
    }

    private fun compressedString(s: String, n: Int, repeat: Int): java.lang.StringBuilder {
        if (s.length < n) return java.lang.StringBuilder(s)
        val sb = StringBuilder()
        val preString = s.substring(0, n)
        val postString = s.substring(n)
        return if (!postString.startsWith(preString)) {
            if (repeat == 1) sb.append(preString).append(compressedString(postString, n, 1))
            else sb.append(repeat).append(preString).append(compressedString(postString, n, 1))
        } else sb.append(compressedString(postString, n, repeat + 1))
    }
}