package _14주차.전력망을_둘로_나누기

import java.util.*
import kotlin.math.abs
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

    val n1 = 9
    val wires1 = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(4, 6),
        intArrayOf(4, 7),
        intArrayOf(7, 8),
        intArrayOf(7, 9)
    )
    val answer1 = 3
    val result1 = Solution().solution(n1, wires1)
    printResult(1, result1, answer1)

    val n2 = 4
    val wires2 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))
    val answer2 = 0
    val result2 = Solution().solution(n2, wires2)
    printResult(2, result2, answer2)

    val n3 = 7
    val wires3 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 7),
        intArrayOf(3, 7),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(6, 7)
    )
    val answer3 = 1
    val result3 = Solution().solution(n3, wires3)
    printResult(3, result3, answer3)

    val n4 = 2
    val wires4 = arrayOf(
        intArrayOf(1, 2),
    )
    val answer4 = 0
    val result4 = Solution().solution(n4, wires4)
    printResult(4, result4, answer4)
}

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Integer.MAX_VALUE

        for (i in wires.indices) {
            answer = min(answer, divideTree(i, n, wires))
        }

        return answer
    }

    private fun divideTree(exclude: Int, n: Int, wires: Array<IntArray>): Int {
        val set1 = hashSetOf(wires[exclude][0])
        val set2 = hashSetOf(wires[exclude][1])
        val list = wires.toMutableList().apply { removeAt(exclude) }
        val queue = LinkedList(list)

        while (queue.isNotEmpty()) {
            if (set1.contains(queue.peek()[0]) || set1.contains(queue.peek()[1])) {
                set1.addAll(queue.poll().toSet())
                continue
            }

            if (set2.contains(queue.peek()[0]) || set2.contains(queue.peek()[1])) {
                set2.addAll(queue.poll().toSet())
                continue
            }

            queue.add(queue.poll())
        }

        return abs(set1.size - set2.size)
    }
}