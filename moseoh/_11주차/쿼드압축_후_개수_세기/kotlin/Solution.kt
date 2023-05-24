package _11주차.쿼드압축_후_개수_세기.kotlin

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

    val arr1 = arrayOf(intArrayOf(1, 1, 0, 0), intArrayOf(1, 0, 0, 0), intArrayOf(1, 0, 0, 1), intArrayOf(1, 1, 1, 1))
    val answer1 = intArrayOf(4, 9)
    val result1 = Solution().solution(arr1)
    printResult(1, result1, answer1)

    val arr2 = arrayOf(
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 1),
        intArrayOf(0, 1, 1, 1, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 1, 1, 1, 1),
        intArrayOf(0, 1, 0, 0, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 0, 0, 1, 1),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 1, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 1, 1, 1, 1)
    )
    val answer2 = intArrayOf(10, 15)
    val result2 = Solution().solution(arr2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        val answer = intArrayOf(0, 0)
        val n = arr.size
        for (i in generateSequence(n) { it / 2 }.takeWhile { it > 0 }) {
            for (x in 0 until n step i) {
                for (y in 0 until n step i) {
                    if (canCompress(arr, x, y, i)) {
                        answer[arr[x][y]]++
                        compress(arr, x, y, i)
                    }
                }
            }
        }
        return answer
    }

    private fun canCompress(arr: Array<IntArray>, indexX: Int, indexY: Int, length: Int): Boolean {
        val target = arr[indexX][indexY]
        if (target == -1) return false
        for (x in indexX until indexX + length) {
            for (y in indexY until indexY + length) {
                if (arr[x][y] != target) return false
            }
        }
        return true
    }

    private fun compress(arr: Array<IntArray>, indexX: Int, indexY: Int, length: Int) {
        for (x in indexX until indexX + length) {
            for (y in indexY until indexY + length) {
                arr[x][y] = -1
            }
        }
    }
}