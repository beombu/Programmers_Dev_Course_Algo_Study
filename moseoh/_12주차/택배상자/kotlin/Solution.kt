package _12주차.택배상자.kotlin

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

    val order1 = intArrayOf(4, 3, 1, 2, 5)
    val answer1 = 2
    val result1 = Solution().solution(order1)
    printResult(1, result1, answer1)

    val order2 = intArrayOf(5, 4, 3, 2, 1)
    val answer2 = 5
    val result2 = Solution().solution(order2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(order: IntArray): Int {
        val subContainer = Stack<Int>()
        val container = (1..order.size).toCollection(LinkedList())
        val truck = mutableListOf<Int>()

        var index = 0
        while (true) {
            subContainer.push(container.pop())

            while (subContainer.isNotEmpty() && subContainer.peek() == order[index]) {
                truck.add(subContainer.pop())
                index++
            }

            if (
                (container.isEmpty() && subContainer.isEmpty()) ||
                (container.isEmpty() && subContainer.isNotEmpty() && subContainer.peek() != order[index])
            ) {
                break
            }
        }

        return truck.size
    }
}