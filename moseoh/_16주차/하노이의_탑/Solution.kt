package _16주차.하노이의_탑

fun main() {
    fun printResult(index: Int, result: Array<IntArray>, answer: Array<IntArray>) {
        val correct = result.contentDeepEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentDeepToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentDeepToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val n1 = 2
    val answer1 = arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3))
    val result1 = Solution().solution(n1)
    printResult(1, result1, answer1)
}


class Solution {
    lateinit var list: ArrayList<IntArray>

    fun solution(n: Int): Array<IntArray> {
        list = ArrayList()
        hanoi(1, 2, 3, n)
        val result = Array(list.size) { IntArray(2) }
        for (i in list.indices) {
            result[i][0] = list[i][0]
            result[i][1] = list[i][1]
        }
        return result
    }

    private fun hanoi(s: Int, v: Int, e: Int, n: Int) {
        val move = intArrayOf(s, e)
        if (n == 1) list!!.add(move) else {
            hanoi(s, e, v, n - 1)
            list.add(move)
            hanoi(v, s, e, n - 1)
        }
    }
}