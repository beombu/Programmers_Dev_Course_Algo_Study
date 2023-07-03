package _17주차.시소_짝꿍

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

    val weights1 = intArrayOf(100, 180, 360, 100, 270)
    val answer1 = 4L
    val result1 = Solution().solution(weights1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(weights: IntArray): Long {
        val arr = IntArray(size = 1001)
        var answer = 0L
        weights.forEach {
            canNum(it).forEach { n -> answer += arr[n] }
            arr[it] += 1
        }

        return answer
    }

    private fun canNum(num: Int): IntArray {
        val arr = doubleArrayOf(
            num.toDouble(),
            num / 2.0,
            num * 2 / 3.0,
            num * 3 / 4.0,
            num * 2.0,
            num * 3 / 2.0,
            num * 4 / 3.0
        )

        return arr.filter { it <= 1000 && it.toInt().toDouble() == it }.map { it.toInt() }.toIntArray()
    }
}