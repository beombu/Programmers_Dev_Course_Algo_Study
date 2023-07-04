package _17주차.테이블_해시_함수

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

    val data1 = arrayOf(intArrayOf(2, 2, 6), intArrayOf(1, 5, 10), intArrayOf(4, 2, 9), intArrayOf(3, 8, 3))
    val col1 = 2
    val row_begin1 = 2
    val row_end1 = 3
    val answer1 = 4
    val result1 = Solution().solution(data1, col1, row_begin1, row_end1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        data.sortWith(compareBy<IntArray> { it[col - 1] }.thenByDescending { it[0] })

        var answer: Int = 0
        for (i in row_begin..row_end) {
            var sum = 0
            val arr = data[i - 1]
            arr.forEach { sum += (it % i) }
            answer = answer xor sum
        }

        return answer
    }
}