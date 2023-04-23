package _6주차.할인행사.kotlin

fun main() {
    val want1 = arrayOf("banana", "apple", "rice", "pork", "pot")
    val number1 = intArrayOf(3, 2, 2, 2, 1)
    val discount1 = arrayOf(
        "chicken",
        "apple",
        "apple",
        "banana",
        "rice",
        "apple",
        "pork",
        "banana",
        "pork",
        "rice",
        "pot",
        "banana",
        "apple",
        "banana"
    )
    val answer1 = 3
    val result1 = Solution().solution(want1, number1, discount1)
    println(result1)
    check(result1 == answer1) { "오답" }

    val want2 = arrayOf("apple")
    val number2 = intArrayOf(10)
    val discount2 =
        arrayOf("banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana")
    val answer2 = 0
    val result2 = Solution().solution(want2, number2, discount2)
    println(result2)
    check(result2 == answer2) { "오답" }
}

class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        return (0..discount.size - 10).fold(0) { acc, startIndex ->
            val discountTenDays = discount.slice(startIndex until startIndex + 10)

            var isMemberShip = true
            want.forEachIndexed { index, s ->
                isMemberShip = isMemberShip && discountTenDays.count { it == s } == number[index]
            }

            if (isMemberShip) acc + 1
            else acc
        }
    }
}