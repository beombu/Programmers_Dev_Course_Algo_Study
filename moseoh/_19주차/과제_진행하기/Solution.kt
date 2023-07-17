package _19주차.과제_진행하기

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {
    fun printResult(index: Int, result: Array<String>, answer: Array<String>) {
        val correct = result.contentEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val plans1 =
        arrayOf(arrayOf("korean", "11:40", "30"), arrayOf("english", "12:10", "20"), arrayOf("math", "12:30", "40"))
    val answer1 = arrayOf("korean", "english", "math")
    val result1 = Solution().solution(plans1)
    printResult(1, result1, answer1)

    val plans2 = arrayOf(
        arrayOf("science", "12:40", "50"),
        arrayOf("music", "12:20", "40"),
        arrayOf("history", "14:00", "30"),
        arrayOf("computer", "12:30", "100")
    )
    val answer2 = arrayOf("science", "history", "computer", "music")
    val result2 = Solution().solution(plans2)
    printResult(2, result2, answer2)

    val plans3 = arrayOf(arrayOf("aaa", "12:00", "20"), arrayOf("bbb", "12:10", "30"), arrayOf("ccc", "12:40", "10"))
    val answer3 = arrayOf("bbb", "ccc", "aaa")
    val result3 = Solution().solution(plans3)
    printResult(3, result3, answer3)
}


class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val planArray = plans.map {
            Plan(
                it[0],
                LocalTime.parse(it[1], formatter),
                it[2].toInt()
            )
        }.toTypedArray().sortedBy { it.time }

        val answer = mutableListOf<String>()
        val stack = Stack<Plan>()
        stack.push(planArray[0])
        var currentTime = stack.peek().time

        for (i in 1 until planArray.size) {
            val nextPlan = planArray[i]
            while (currentTime != nextPlan.time) {
                currentTime = currentTime.plusMinutes(1)
                if (stack.isNotEmpty()) {
                    val lastPlan = stack.peek()
                    lastPlan.amount--
                    if (lastPlan.amount == 0) {
                        answer.add(stack.pop().name)
                    }
                }
            }
            stack.add(nextPlan)
        }

        while (stack.isNotEmpty()) {
            answer.add(stack.pop().name)
        }

        return answer.toTypedArray()
    }

    data class Plan(
        val name: String,
        val time: LocalTime,
        var amount: Int,
    )
}