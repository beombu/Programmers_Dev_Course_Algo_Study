package _5주차.연속부분수열합의개수

fun main() {
    val elements1 = intArrayOf(7, 9, 1, 1, 4)
    val answer1 = 18
    val result1 = Solution().solution(elements1)
    println(result1)
    check(result1 == answer1) { "오답" }
}

class Solution {
    fun solution(elements: IntArray): Int {
        val circleElement = elements.plus(elements)
        val set = mutableSetOf<Int>()
        (elements.indices).forEach { i ->
            (elements.indices).forEach { j ->
                set.add(circleElement.slice(j..j + i).sum())
            }
        }
        return set.size
    }
}