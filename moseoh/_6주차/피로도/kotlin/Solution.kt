package _6주차.피로도.kotlin

fun main() {
    val k1 = 80
    val dungeons1 = arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10))
    val answer1 = 3
    val result1 = Solution().solution(k1, dungeons1)
    println(result1)
    check(result1 == answer1) { "오답" }
}

class Solution {
    lateinit var isVisited: BooleanArray
    var answer = Int.MIN_VALUE

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        isVisited = BooleanArray(dungeons.size)
        explorer(k, dungeons, 0, 0)
        return answer
    }

    private fun explorer(k: Int, dungeons: Array<IntArray>, dept: Int, count: Int) {
        if (dept == dungeons.size) {
            answer = answer.coerceAtLeast(count)
            return
        }
        for (i in dungeons.indices) {
            if (!isVisited[i]) {
                isVisited[i] = true
                if (k >= dungeons[i][0]) {
                    explorer(k - dungeons[i][1], dungeons, dept + 1, count + 1)
                } else {
                    explorer(k, dungeons, dept + 1, count)
                }
                isVisited[i] = false
            }
        }
    }
}