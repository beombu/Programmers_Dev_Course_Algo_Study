package _12주차.두_큐_합_같게_만들기.kotlin

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

    val queue11 = intArrayOf(3, 2, 7, 2)
    val queue21 = intArrayOf(4, 6, 5, 1)
    val answer1 = 2
    val result1 = Solution().solution(queue11, queue21)
    printResult(1, result1, answer1)

    val queue12 = intArrayOf(1, 2, 1, 2)
    val queue22 = intArrayOf(1, 10, 1, 2)
    val answer2 = 7
    val result2 = Solution().solution(queue12, queue22)
    printResult(2, result2, answer2)

    val queue13 = intArrayOf(1, 1)
    val queue23 = intArrayOf(1, 5)
    val answer3 = -1
    val result3 = Solution().solution(queue13, queue23)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var sum1 = queue1.sum().toLong()
        var sum2 = queue2.sum().toLong()
        val que1 = queue1.toCollection(LinkedList())
        val que2 = queue2.toCollection(LinkedList())
        val length = (queue1.size + queue2.size) * 2

        var count = 0
        while (sum1 != sum2) {
            count++
            if (sum1 > sum2) {
                sum1 -= que1.peek()
                sum2 += que1.peek()
                que2.add(que1.poll())
            } else {
                sum1 += que2.peek()
                sum2 -= que2.peek()
                que1.add(que2.poll())
            }

            if (count > length) return -1
        }
        return count
    }

}