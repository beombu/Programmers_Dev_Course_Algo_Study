package _13주차.연속된_부분_수열의_합.kotlin

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

    val sequence1 = intArrayOf(1, 2, 3, 4, 5)
    val k1 = 7
    val answer1 = intArrayOf(2, 3)
    val result1 = Solution().solution(sequence1, k1)
    printResult(1, result1, answer1)

    val sequence2 = intArrayOf(1, 1, 1, 2, 3, 4, 5)
    val k2 = 5
    val answer2 = intArrayOf(6, 6)
    val result2 = Solution().solution(sequence2, k2)
    printResult(2, result2, answer2)

    val sequence3 = intArrayOf(2, 2, 2, 2, 2)
    val k3 = 6
    val answer3 = intArrayOf(0, 2)
    val result3 = Solution().solution(sequence3, k3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer = Pair(0, sequence.size)
        val que = LinkedList<Pair<Int, Int>>()
        var sum = 0
        for (i in sequence.indices) {
            que.add(Pair(i, sequence[i]))
            sum += que.last.second
            while (sum > k) {
                sum -= que.poll().second
            }

            if (sum == k) {
                val startIndex = que.first().first
                val endIndex = que.last().first
                if (endIndex - startIndex < answer.second - answer.first) {
                    answer = Pair(startIndex, endIndex)
                }
            }
        }

        return intArrayOf(answer.first, answer.second)
    }
}