package _10주차.가장_큰_수.kotlin

fun main() {
    fun printResult(index: Int, result: String, answer: String) {
        val correct = result == answer
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val numbers1 = intArrayOf(6, 10, 2)
    val answer1 = "6210"
    val result1 = Solution().solution(numbers1)
    printResult(1, result1, answer1)

    val numbers2 = intArrayOf(3, 30, 34, 5, 9)
    val answer2 = "9534330"
    val result2 = Solution().solution(numbers2)
    printResult(2, result2, answer2)

    val numbers3 = intArrayOf(30, 30, 31, 3, 35, 41, 4, 54, 45)
    val answer3 = "5445441353313030"
    val result3 = Solution().solution(numbers3)
    printResult(3, result3, answer3)

    val numbers4 = intArrayOf(1, 11, 13, 10, 0)
    val answer4 = "13111100"
    val result4 = Solution().solution(numbers4)
    printResult(4, result4, answer4)

    val numbers5 = intArrayOf(0, 0, 70)
    val answer5 = "7000"
    val result5 = Solution().solution(numbers5)
    printResult(5, result5, answer5)

    val numbers6 = intArrayOf(0, 0, 0)
    val answer6 = "0"
    val result6 = Solution().solution(numbers6)
    printResult(6, result6, answer6)

    val numbers7 = intArrayOf(48, 484, 533)
    val answer7 = "53348484"
    val result7 = Solution().solution(numbers7)
    printResult(7, result7, answer7)

    val numbers8 = intArrayOf(34, 3444, 32, 3222)
    val answer8 = "344434323222"
    val result8 = Solution().solution(numbers8)
    printResult(8, result8, answer8)

    val numbers9 = intArrayOf(1, 10, 100, 1000)
    val answer9 = "1101001000"
    val result9 = Solution().solution(numbers9)
    printResult(9, result9, answer9)

    val numbers10 = intArrayOf(979, 97, 978, 81, 818, 817)
    val answer10 = "9799797881881817"
    val result10 = Solution().solution(numbers10)
    printResult(10, result10, answer10)
}

class Solution {
    fun solution(numbers: IntArray): String {
        return numbers
            .sortedByDescending { it.toString().repeat(4) }
            .joinToString("")
            .let { if (it.matches(Regex("^0+$"))) "0" else it }
    }
}