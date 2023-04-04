package _4주차.멀리뛰기.kotlin

fun main() {
    val n1 = 4
    check(Solution().solution(n1) == 5.toLong()) { "오답" }

    val n2 = 3
    check(Solution().solution(n2) == 3.toLong()) { "오답" }
}

class Solution {
    private val dp = IntArray(2001)

    fun solution(n: Int): Long {
        dp[1] = 1
        dp[2] = 2
        for (i in 3 until dp.size) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
        }
        return dp[n].toLong()
    }
}
