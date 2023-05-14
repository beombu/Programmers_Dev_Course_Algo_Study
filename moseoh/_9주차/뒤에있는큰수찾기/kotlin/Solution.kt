package _9주차.뒤에있는큰수찾기.kotlin

import java.util.*

fun main() {
    fun printResult(index: Int, result: IntArray, answer: IntArray) {
        val correct = result.contentEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val numbers1 = intArrayOf(2, 3, 3, 5)
    val answer1 = intArrayOf(3, 5, 5, -1)
    val result1 = Solution().solution(numbers1)
    printResult(1, result1, answer1)

    val numbers2 = intArrayOf(9, 1, 5, 3, 6, 2)
    val answer2 = intArrayOf(-1, 5, 6, 6, -1, -1)
    val result2 = Solution().solution(numbers2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }
        val stack = Stack<Int>()
        for (i in answer.size - 1 downTo 0) {
            while (stack.isNotEmpty() && stack.peek() <= numbers[i]) {
                stack.pop()
            }
            if (stack.isNotEmpty()) {
                answer[i] = stack.peek()
            }
            stack.push(numbers[i])
        }
        return answer
    }
}