package _5주차.튜플

import java.util.regex.Pattern

fun main() {
//    val s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}"
//    val answer1 = intArrayOf(2, 1, 3, 4)
//    val result1 = Solution().solution(s1)
//    println(result1.contentToString())
//    check(result1.contentEquals(answer1)) { "오답" }

    val s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}"
    val answer2 = intArrayOf(2, 1, 3, 4)
    val result2 = Solution().solution(s2)
    println(result2.contentToString())
    check(result2.contentEquals(answer2)) { "오답" }

    val s3 = "{{20,111},{111}}"
    val answer3 = intArrayOf(111, 20)
    val result3 = Solution().solution(s3)
    println(result3.contentToString())
    check(result3.contentEquals(answer3)) { "오답" }

    val s4 = "{{123}}"
    val answer4 = intArrayOf(123)
    val result4 = Solution().solution(s4)
    println(result4.contentToString())
    check(result4.contentEquals(answer4)) { "오답" }

    val s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}"
    val answer5 = intArrayOf(3, 2, 4, 1)
    val result5 = Solution().solution(s5)
    println(result5.contentToString())
    check(result5.contentEquals(answer5)) { "오답" }
}

class Solution {
    fun solution(s: String): IntArray {
        return s.substring(2 until s.length - 2)
            .split("},{")
            .map { it.split(",").map { num -> num.toInt() } }
            .toList().sortedBy { it.size }
            .fold(setOf<Int>()) { acc, list -> acc.union(list) }.toIntArray()
    }

    fun solution2(s: String): IntArray {
        val pattern = Pattern.compile("(\\{[0-9,]*\\})")
        val matcher = pattern.matcher(s.substring(1, s.length - 1))

        val inputList = mutableListOf<IntArray>()
        while (matcher.find()) {
            val str = matcher.group()
            val intArray = str.substring(1, str.length - 1).split(",").map { it.toInt() }.toIntArray()
            inputList.add(intArray)
        }
        inputList.sortBy { it.size }

        val answer = mutableListOf<Int>()
        inputList.forEach { arr -> arr.forEach { if (!answer.contains(it)) answer.add(it) } }
        return answer.toIntArray()
    }
}