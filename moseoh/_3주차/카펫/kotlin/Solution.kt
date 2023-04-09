package _3주차.카펫.kotlin

fun main() {
    val brown1 = 10
    val yellow1 = 2
    check(Solution().solution(brown1, yellow1).contentEquals(intArrayOf(4, 3))) { "오답" }

    val brown2 = 8
    val yellow2 = 1
    check(Solution().solution(brown2, yellow2).contentEquals(intArrayOf(3, 3))) { "오답" }

    val brown3 = 24
    val yellow3 = 24
    check(Solution().solution(brown3, yellow3).contentEquals(intArrayOf(8, 6))) { "오답" }
}

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val length = brown / 2 + 2
        var width = length - 1
        var height = length - width

        while (brown + yellow != width * height) {
            width--
            height++
        }

        return intArrayOf(width, height)
    }
}
