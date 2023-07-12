package _18주차.리코쳇_로봇

import java.util.*

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

    val board1 = arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D....")
    val answer1 = 7
    val result1 = Solution().solution(board1)
    printResult(1, result1, answer1)

    val board2 = arrayOf(".D.R", "....", ".G..", "...D")
    val answer2 = -1
    val result2 = Solution().solution(board2)
    printResult(2, result2, answer2)
}


class Solution {
    private val dx = intArrayOf(0, 1, 0, -1)
    private val dy = intArrayOf(1, 0, -1, 0)

    fun solution(board: Array<String>): Int {
        val que = LinkedList<Triple<Int, Int, Int>>()
        que.add(getStartIndex(board))
        val isVisited = Array(board.size) { BooleanArray(board[0].length) }
        while (que.isNotEmpty()) {
            val index = que.poll()
            val y = index.first
            val x = index.second
            val count = index.third

            if (board[y][x] == 'G') return count
            for (i in 0..3) {
                val nextIndex = getNextIndex(x, y, dx[i], dy[i], board)
                val ny = nextIndex.first
                val nx = nextIndex.second

                if (ny == y && nextIndex.second == x) continue
                if (isVisited[ny][nx]) continue
                que.add(Triple(ny, nx, index.third + 1))
                isVisited[ny][nx] = true
            }
        }
        return -1
    }

    private fun getNextIndex(
        x: Int,
        y: Int,
        dx: Int,
        dy: Int,
        board: Array<String>,
    ): Pair<Int, Int> {
        var currentX = x
        var currentY = y
        while (true) {
            if (currentX + dx >= board[0].length || currentX + dx < 0) return Pair(currentY, currentX)
            if (currentY + dy >= board.size || currentY + dy < 0) return Pair(currentY, currentX)
            if (board[currentY + dy][currentX + dx] == 'D') return Pair(currentY, currentX)
            currentX += dx
            currentY += dy
        }
    }

    private fun getStartIndex(board: Array<String>): Triple<Int, Int, Int> {
        for (i in board.indices) {
            board[i].forEachIndexed { index, c ->
                if (c == 'R') return Triple(i, index, 0)
            }
        }

        return Triple(-1, -1, -1)
    }
}