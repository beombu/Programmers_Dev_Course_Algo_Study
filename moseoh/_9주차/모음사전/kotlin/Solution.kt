package _9주차.모음사전.kotlin

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

    val word1 = "AAAAE"
    val answer1 = 6
    val result1 = Solution().solution(word1)
    printResult(1, result1, answer1)

    val word2 = "AAAE"
    val answer2 = 10
    val result2 = Solution().solution(word2)
    printResult(2, result2, answer2)

    val word3 = "I"
    val answer3 = 1563
    val result3 = Solution().solution(word3)
    printResult(3, result3, answer3)

    val word4 = "EIO"
    val answer4 = 1189
    val result4 = Solution().solution(word4)
    printResult(4, result4, answer4)
}

class Solution {
    fun solution(word: String): Int {
        stringList()
        return list.indexOf(word)
    }

    private val array = charArrayOf('A', 'E', 'I', 'O', 'U')
    private val list = mutableListOf<String>()
    private fun stringList(str: String = "") {
        if (str.length > 5) return

        list.add(str)

        array.forEach {
            stringList(str + it)
        }
    }
}