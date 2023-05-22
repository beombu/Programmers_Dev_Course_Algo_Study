package _11주차.롤케이크_자르기.kotlin

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

    val topping1 = intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)
    val answer1 = 2
    val result1 = Solution().solution(topping1)
    printResult(1, result1, answer1)

    val topping2 = intArrayOf(1, 2, 3, 1, 4)
    val answer2 = 0
    val result2 = Solution().solution(topping2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(topping: IntArray): Int {
        var answer = 0
        val leftSet = mutableSetOf<Int>()
        val array = IntArray(topping.size + 1)
        var rightSize = 0
        topping.forEach { if (array[it]++ == 0) rightSize++ }

        topping.forEach {
            leftSet.add(it)
            if (--array[it] == 0) rightSize--
            if (leftSet.size == rightSize) {
                answer++
            }
        }

        return answer
    }
}