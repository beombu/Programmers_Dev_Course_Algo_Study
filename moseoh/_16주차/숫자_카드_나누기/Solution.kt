package _16주차.숫자_카드_나누기

import kotlin.math.max

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

    val arrayA1 = intArrayOf(10, 17)
    val arrayB1 = intArrayOf(5, 20)
    val answer1 = 0
    val result1 = Solution().solution(arrayA1, arrayB1)
    printResult(1, result1, answer1)

    val arrayA2 = intArrayOf(10, 20)
    val arrayB2 = intArrayOf(5, 17)
    val answer2 = 10
    val result2 = Solution().solution(arrayA2, arrayB2)
    printResult(2, result2, answer2)

    val arrayA3 = intArrayOf(14, 35, 119)
    val arrayB3 = intArrayOf(18, 30, 102)
    val answer3 = 7
    val result3 = Solution().solution(arrayA3, arrayB3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        return max(getAnswer(getNums(arrayA), arrayB), getAnswer(getNums(arrayB), arrayA))
    }

    private fun getNums(array: IntArray): IntArray {
        fun isNum(num: Int, array: IntArray): Boolean {
            for (i in array.indices) {
                if (array[i] % num != 0) return false
            }
            return true
        }

        val num = array.minOrNull()!!
        val list = mutableListOf<Int>()
        for (i in num downTo 1) {
            if (num % i == 0 && isNum(i, array)) list.add(i)
        }
        return list.toIntArray()
    }

    private fun getAnswer(nums: IntArray, array: IntArray): Int {
        fun isAnswer(num: Int, array: IntArray): Boolean {
            for (i in array.indices) {
                if (array[i] % num == 0) return false
            }
            return true
        }
        for (i in nums.indices) {
            if (isAnswer(nums[i], array)) return nums[i]
        }
        return 0
    }
}