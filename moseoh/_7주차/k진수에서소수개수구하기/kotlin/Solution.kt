package _7주차.k진수에서소수개수구하기.kotlin

import kotlin.math.sqrt

fun main() {
    val n1 = 437674
    val k1 = 3
    val answer1 = 3
    val result1 = Solution().solution(n1, k1)
    check(result1 == answer1) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: $result1\n" +
                "\t- 기댓값: $answer1\n"
    }

    val n2 = 110011
    val k2 = 10
    val answer2 = 2
    val result2 = Solution().solution(n2, k2)
    check(result2 == answer2) {
        "\n\n테스트 케이스 2\n" +
                "\t- 실행 결과: $result2\n" +
                "\t- 기댓값: $answer2\n"
    }
}

class Solution {
    fun solution(n: Int, k: Int): Int {
        return n.toString(k).split("0").count {
            isPrime(it)
        }
    }

    private fun isPrime(str: String): Boolean {
        if (str.isEmpty()) return false

        val number = str.toLong()
        if (number <= 1) return false

        for (i in 2..sqrt(number.toDouble()).toLong()) {
            if (number % i == 0L) return false
        }

        return true
    }
}