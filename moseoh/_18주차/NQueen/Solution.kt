package _18주차.NQueen

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

    val n1 = 4
    val answer1 = 2
    val result1 = Solution().solution(n1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(n: Int): Int {
        val col = IntArray(n)
        return queen(0, n, col)
    }

    private fun possible(x: Int, y: Int, n: Int, col: IntArray): Boolean {
        for (i in 0 until x) {
            if (y == col[i] || Math.abs(y - col[i]) == x - i) {
                return false
            }
        }
        return true
    }

    private fun queen(x: Int, n: Int, col: IntArray): Int {
        if (x == n) {
            return 1
        }
        var count = 0

        for (y in 0 until n) {
            if (possible(x, y, n, col)) {
                col[x] = y
                count += queen(x + 1, n, col)
            }
        }
        return count
    }


}