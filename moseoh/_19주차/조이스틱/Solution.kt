package _19주차.조이스틱

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

    val name1 = "JEROEN"
    val answer1 = 56
    val result1 = Solution().solution(name1)
    printResult(1, result1, answer1)

    val name2 = "JAN"
    val answer2 = 23
    val result2 = Solution().solution(name2)
    printResult(2, result2, answer2)
}


internal class Solution {
    fun solution(name: String): Int {
        var answer = 0
        var move = name.length - 1
        for (i in name.indices) {
            answer += changeAlphabetCount(name[i])
            var index = i + 1
            while (index < name.length && name[index] == 'A') {
                index++
            }
            move = min(move, 2 * i + name.length - index)
            move = min(move, (name.length - index) * 2 + i)
        }
        return answer + move
    }

    private fun changeAlphabetCount(ch: Char): Int {
        return min(ch.code - 'A'.code, 'Z'.code - ch.code + 1)
    }
}