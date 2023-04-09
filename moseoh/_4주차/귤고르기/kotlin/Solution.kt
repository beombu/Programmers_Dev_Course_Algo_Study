package _4주차.귤고르기.kotlin

import java.util.*

fun main() {
    val k1 = 6
    val tangerine1 = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
    check(Solution().solution(k1, tangerine1) == 3) { "오답" }

    val k2 = 4
    val tangerine2 = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
    check(Solution().solution(k2, tangerine2) == 2) { "오답" }

    val k3 = 2
    val tangerine3 = intArrayOf(1, 1, 1, 1, 2, 2, 2, 3)
    check(Solution().solution(k3, tangerine3) == 1) { "오답" }
}

class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        tangerine.map {
            val current = map.getOrDefault(it, 0)
            map[it] = current + 1
        }

        val queue = PriorityQueue<Int>(Collections.reverseOrder())
        map.values.forEach { queue.add(it) }

        var answer = 0
        var sum = 0
        while (queue.isNotEmpty() && sum < k) {
            sum += queue.poll()
            answer++
        }

        return answer
    }
}
