package _12주차.프로세스.kotlin

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

    val priorities1 = intArrayOf(2, 1, 3, 2)
    val location1 = 2
    val answer1 = 1
    val result1 = Solution().solution(priorities1, location1)
    printResult(1, result1, answer1)

    val priorities2 = intArrayOf(1, 1, 9, 1, 1, 1)
    val location2 = 0
    val answer2 = 5
    val result2 = Solution().solution(priorities2, location2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var count = 1
        val priorityQueue = PriorityQueue(Collections.reverseOrder<Int>())
        val processQueue: Queue<Process> = LinkedList()
        for (i in priorities.indices) {
            priorityQueue.add(priorities[i])
            processQueue.add(Process(i, priorities[i]))
        }
        while (!processQueue.isEmpty()) {
            if (processQueue.peek().priority != priorityQueue.peek()) {
                processQueue.add(processQueue.poll())
            } else {
                if (processQueue.peek().index == location) {
                    break
                }
                processQueue.poll()
                priorityQueue.poll()
                count++
            }
        }
        return count
    }

    data class Process(var index: Int, var priority: Int)
}