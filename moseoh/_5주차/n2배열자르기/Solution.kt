package _5주차.n2배열자르기

fun main() {
    val n1 = 3
    val left1 = 2L
    val right1 = 5L
    val answer1 = intArrayOf(3, 2, 2, 3)
    val result1 = Solution().solution(n1, left1, right1)
    println(result1.contentToString())
    check(result1.contentEquals(answer1)) { "오답" }

    val n2 = 4
    val left2 = 7L
    val right2 = 14L
    val answer2 = intArrayOf(4, 3, 3, 3, 4, 4, 4, 4)
    val result2 = Solution().solution(n2, left2, right2)
    println(result2.contentToString())
    check(result2.contentEquals(answer2)) { "오답" }

}

class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        return (left..right).map {
            maxOf((it / n + 1).toInt(), (it % n + 1).toInt())
        }.toIntArray()
    }
}