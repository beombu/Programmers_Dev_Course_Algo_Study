package _13주차.무인도_여행.kotlin

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

    val maps1 = arrayOf("X591X", "X1X5X", "X231X", "1XXX1")
    val answer1 = intArrayOf(1, 1, 27)
    val result1 = Solution().solution(maps1)
    printResult(1, result1, answer1)

    val maps2 = arrayOf("XXX", "XXX", "XXX")
    val answer2 = intArrayOf(-1)
    val result2 = Solution().solution(maps2)
    printResult(2, result2, answer2)
}

class Solution {
    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, -1, 0, 1)

    fun solution(maps: Array<String>): IntArray {
        val area = maps.map {
            it.toCharArray()
        }.toTypedArray()

        val answer = mutableListOf<Int>()
        area.forEachIndexed { y, arr ->
            arr.forEachIndexed { x, _ ->
                val result = search(area, x, y)
                if (result > 0) answer.add(result)
            }
        }

        return if (answer.isEmpty()) intArrayOf(-1) else answer.toIntArray().sortedArray()
    }

    private fun search(area: Array<CharArray>, x: Int, y: Int): Int {
        if (x < 0 || area[0].size <= x) return 0
        if (y < 0 || area.size <= y) return 0
        if (area[y][x] == 'X') return 0

        var newSum = Character.getNumericValue(area[y][x])
        area[y][x] = 'X'

        for (i in dx.indices)
            newSum += search(area, x + dx[i], y + dy[i])

        return newSum
    }
}