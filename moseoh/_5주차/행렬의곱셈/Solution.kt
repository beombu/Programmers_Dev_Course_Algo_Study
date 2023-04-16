package _5주차.행렬의곱셈

fun main() {
    val arr11 = arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1))
    val arr21 = arrayOf(intArrayOf(3, 3), intArrayOf(3, 3))
    val answer1 = arrayOf(intArrayOf(15, 15), intArrayOf(15, 15), intArrayOf(15, 15))
    val result1 = Solution().solution(arr11, arr21)
    println(result1.contentDeepToString())
    check(result1.contentDeepEquals(answer1)) { "\n\n오답\n입력값: ${result1.contentDeepToString()}\n기댓값: ${answer1.contentDeepToString()}\n" }

    val arr12 = arrayOf(intArrayOf(2, 3, 2), intArrayOf(4, 2, 4), intArrayOf(3, 1, 4))
    val arr22 = arrayOf(intArrayOf(5, 4, 3), intArrayOf(2, 4, 1), intArrayOf(3, 1, 1))
    val answer2 = arrayOf(intArrayOf(22, 22, 11), intArrayOf(36, 28, 18), intArrayOf(29, 20, 14))
    val result2 = Solution().solution(arr12, arr22)
    println(result2.contentDeepToString())
    check(result2.contentDeepEquals(answer2)) { "오답" }
}

class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val m = arr1.size
        val n = arr2[0].size
        val l = arr2.size

        val answer = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                for (k in 0 until l) {
                    answer[i][j] += arr1[i][k] * arr2[k][j]
                }
            }
        }

        return answer
    }
}