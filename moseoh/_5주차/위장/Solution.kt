package _5주차.위장

fun main() {
    val clothes1 = arrayOf(
        arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear")
    )
    val answer1 = 5
    val result1 = Solution().solution(clothes1)
    println(result1)
    check(result1 == answer1) { "오답" }

    val clothes2 =
        arrayOf(arrayOf("crow_mask", "face"), arrayOf("blue_sunglasses", "face"), arrayOf("smoky_makeup", "face"))
    val answer2 = 3
    val result2 = Solution().solution(clothes2)
    println(result2)
    check(result2 == answer2) { "오답" }
}

class Solution {
    fun solution(clothes: Array<Array<String>>): Int =
        clothes.groupBy { it[1] }.map { it.value.size + 1 }.fold(1) { acc, i -> acc * i } - 1
}