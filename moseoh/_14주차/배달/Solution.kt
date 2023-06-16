package _14주차.배달

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

    val N1 = 5
    val road1 = arrayOf(
        intArrayOf(1, 2, 1),
        intArrayOf(2, 3, 3),
        intArrayOf(5, 2, 2),
        intArrayOf(1, 4, 2),
        intArrayOf(5, 3, 1),
        intArrayOf(5, 4, 2),
    )
    val K1 = 3
    val answer1 = 4
    val result1 = Solution().solution(N1, road1, K1)
    printResult(1, result1, answer1)

    val N2 = 6
    val road2 = arrayOf(
        intArrayOf(1, 2, 1),
        intArrayOf(1, 3, 2),
        intArrayOf(2, 3, 2),
        intArrayOf(3, 4, 3),
        intArrayOf(3, 5, 2),
        intArrayOf(3, 5, 3),
        intArrayOf(5, 6, 1),
    )
    val K2 = 4
    val answer2 = 4
    val result2 = Solution().solution(N2, road2, K2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val town = IntArray(N + 1) { 500001 }.apply { this[1] = 0 }
        val pq = PriorityQueue<Node>().apply { offer(Node(1, 0)) }

        while (pq.isNotEmpty()) {
            val now = pq.poll()
            if (now.distance > town[now.index]) continue
            for (i in road.indices) {
                if (road[i][0] == now.index) {
                    val cost = now.distance + road[i][2]
                    val idx = road[i][1]
                    if (cost < town[idx]) {
                        town[idx] = cost
                        pq.offer(Node(idx, cost))
                    }
                } else if (road[i][1] == now.index) {
                    val cost = now.distance + road[i][2]
                    val idx = road[i][0]
                    if (cost < town[idx]) {
                        town[idx] = cost
                        pq.offer(Node(idx, cost))
                    }
                }
            }
        }
        
        return town.count { it <= k }
    }

    data class Node(val index: Int, val distance: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.distance.compareTo(other.distance)
        }
    }
}