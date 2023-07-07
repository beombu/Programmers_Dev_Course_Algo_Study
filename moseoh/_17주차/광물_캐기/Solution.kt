package _17주차.광물_캐기

import kotlin.math.min

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

    val picks1 = intArrayOf(1, 3, 2)
    val minerals1 = arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")
    val answer1 = 12
    val result1 = Solution().solution(picks1, minerals1)
    printResult(1, result1, answer1)

    val picks2 = intArrayOf(0, 1, 1)
    val minerals2 = arrayOf(
        "diamond",
        "diamond",
        "diamond",
        "diamond",
        "diamond",
        "iron",
        "iron",
        "iron",
        "iron",
        "iron",
        "diamond"
    )
    val answer2 = 50
    val result2 = Solution().solution(picks2, minerals2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        return miningIndex(minerals).sumOf { mining(it, getPick(picks), minerals) }
    }

    private fun mining(startIndex: Int, pick: Int, minerals: Array<String>): Int {
        var result = 0
        if (pick == 0) return result

        for (i in startIndex until min(startIndex + 5, minerals.size)) {
            val stamina = getStamina(minerals[i])
            result += if (stamina < pick) 1 else stamina / pick
        }

        return result
    }

    private fun miningIndex(minerals: Array<String>): IntArray {
        val needStaminaAtIndex = mutableListOf<Pair<Int, Int>>()
        var stamina = 0
        var index = 0
        for (i in minerals.indices) {
            stamina += getStamina(minerals[i])
            if ((i + 1) % 5 == 0 || i == minerals.size - 1) {
                needStaminaAtIndex.add(Pair(index, stamina))
                index = i + 1
                stamina = 0
            }
        }

        return needStaminaAtIndex.sortedByDescending { it.second }.map { it.first }.toIntArray()
    }

    private fun getPick(picks: IntArray): Int {
        for (i in picks.indices) {
            if (picks[i] > 0) {
                picks[i]--
                return if (i == 0) 25 else if (i == 1) 5 else 1
            }
        }
        return 0
    }

    private fun getStamina(mineral: String): Int {
        return when (mineral) {
            "diamond" -> 25
            "iron" -> 5
            "stone" -> 1
            else -> 0
        }
    }
}