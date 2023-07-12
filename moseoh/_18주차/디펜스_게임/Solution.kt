package _18주차.디펜스_게임

import java.util.*

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

    val n1 = 7
    val k1 = 3
    val enemy1 = intArrayOf(4, 2, 4, 5, 3, 3, 1)
    val answer1 = 5
    val result1 = Solution().solution(n1, k1, enemy1)
    printResult(1, result1, answer1)

    val n2 = 2
    val k2 = 4
    val enemy2 = intArrayOf(3, 3, 3, 3)
    val answer2 = 4
    val result2 = Solution().solution(n2, k2, enemy2)
    printResult(2, result2, answer2)
}


class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        val queue = PriorityQueue<Int>(Collections.reverseOrder())
        var sum = 0
        var answer = 0
        var ticket = k

        for (i in enemy.indices) {
            sum += enemy[i]
            queue.add(enemy[i])

            if (sum > n) {
                sum -= queue.poll()
                if (ticket == 0) break
                ticket--
            }

            answer++
        }

        return answer
    }
}