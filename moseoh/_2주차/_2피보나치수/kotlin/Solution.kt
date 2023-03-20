package _2주차._2피보나치수.kotlin

fun main() {
    val n1 = 3
    check(Solution().solution(n1) == 2) { "오답" }

    val n2 = 5
    check(Solution().solution(n2) == 5) { "오답" }
}

class Solution {
    fun solution(n: Int): Int {
        tailrec fun fibonacci(n: Int, a: Int = 0, b: Int = 1): Int =
            if (n == 0) a else fibonacci(n - 1, (a + b) % 1234567, a)
        return fibonacci(n)
    }
}
