package _20주차.요격_시스템

fun main() {
    fun printResult(index: Int, result: Int, answer: Int) {
        val correct = result == (answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val targets1 = arrayOf(
        intArrayOf(4, 5),
        intArrayOf(4, 8),
        intArrayOf(10, 14),
        intArrayOf(11, 13),
        intArrayOf(5, 12),
        intArrayOf(3, 7),
        intArrayOf(1, 4),
    )
    val answer1 = 3
    val result1 = Solution().solution(targets1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(targets: Array<IntArray>): Int {
        targets.sortBy { it[1] }

        var end = targets[0][1]
        var answer = 1
        for (tar in targets) {
            if (tar[0] >= end) {
                end = tar[1]
                answer++
            }
        }
        return answer
    }
}