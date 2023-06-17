package _14주차.행렬_테두리_회전하기

import kotlin.math.min

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

    val rows1 = 6
    val columns1 = 6
    val queries1 = arrayOf(intArrayOf(2, 2, 5, 4), intArrayOf(3, 3, 6, 6), intArrayOf(5, 1, 6, 3))
    val answer1 = intArrayOf(8, 10, 25)
    val result1 = Solution().solution(rows1, columns1, queries1)
    printResult(1, result1, answer1)

    val rows2 = 3
    val columns2 = 3
    val queries2 =
        arrayOf(intArrayOf(1, 1, 2, 2), intArrayOf(1, 2, 2, 3), intArrayOf(2, 1, 3, 2), intArrayOf(2, 2, 3, 3))
    val answer2 = intArrayOf(1, 1, 5, 3)
    val result2 = Solution().solution(rows2, columns2, queries2)
    printResult(2, result2, answer2)

    val rows3 = 100
    val columns3 = 97
    val queries3 = arrayOf(intArrayOf(1, 1, 100, 97))
    val answer3 = intArrayOf(1)
    val result3 = Solution().solution(rows3, columns3, queries3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val arr = initArray(rows, columns)
        return queries.map { rotated(arr, it) }.toIntArray()
    }

    private fun rotated(array: Array<IntArray>, query: IntArray): Int {
        var min = Integer.MAX_VALUE
        var moveIndex = 0
        val move = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )
        val index = intArrayOf(query[0] - 1, query[1] - 1)
        var prev = array[index[0]][index[1]]
        var temp: Int

        while (moveIndex < 4) {
            index[0] += move[moveIndex][0]
            index[1] += move[moveIndex][1]
            if (
                (index[0] == query[0] - 1 && index[1] == query[1] - 1) ||
                (index[0] == query[2] - 1 && index[1] == query[1] - 1) ||
                (index[0] == query[0] - 1 && index[1] == query[3] - 1) ||
                (index[0] == query[2] - 1 && index[1] == query[3] - 1)
            ) {
                moveIndex++
            }
            min = min(min, prev)
            temp = array[index[0]][index[1]]
            array[index[0]][index[1]] = prev
            prev = temp
        }

        return min
    }

    private fun initArray(rows: Int, columns: Int): Array<IntArray> {
        val arr = Array(rows) { IntArray(columns) }

        var num = 1
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                arr[i][j] = num++
            }
        }

        return arr
    }
}