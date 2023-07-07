package _17주차.미로_탈출

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

    val maps1 = arrayOf("SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE")
    val answer1 = 16
    val result1 = Solution().solution(maps1)
    printResult(1, result1, answer1)

    val maps2 = arrayOf("LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO")
    val answer2 = -1
    val result2 = Solution().solution(maps2)
    printResult(2, result2, answer2)
}

class Solution {
    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)

    fun solution(maps: Array<String>): Int {
        val startIndex = getIndexAt(maps, 'S')
        val leverIndex = getIndexAt(maps, 'L')
        val exitIndex = getIndexAt(maps, 'E')

        val startToLeverCount = bfs(maps, startIndex, leverIndex)
        if (startToLeverCount == -1) return -1
        val leverToEndCount = bfs(maps, leverIndex, exitIndex)
        if (leverToEndCount == -1) return -1
        return startToLeverCount + leverToEndCount
    }

    private fun bfs(maps: Array<String>, from: Pair<Int, Int>, to: Pair<Int, Int>): Int {
        val isVisited = Array(maps.size) { BooleanArray(maps[0].length) }
        val que = LinkedList<Triple<Int, Int, Int>>()
        que.add(Triple(from.first, from.second, 0))

        while (que.isNotEmpty()) {
            val current = que.poll()
            val y = current.first
            val x = current.second
            val count = current.third

            if (to.first == y && to.second == x) return count

            for (i in 0..3) {
                val ny = y + dy[i]
                val nx = x + dx[i]

                if (ny < 0 || ny >= maps.size || nx < 0 || nx >= maps[0].length) continue
                if (maps[ny][nx] == 'X') continue
                if (isVisited[ny][nx]) continue
                isVisited[ny][nx] = true

                que.add(Triple(ny, nx, count + 1))
            }
        }
        return -1
    }

    private fun getIndexAt(maps: Array<String>, char: Char): Pair<Int, Int> {
        maps.forEachIndexed { y, s ->
            s.forEachIndexed { x, c ->
                if (c == char) return Pair(y, x)
            }
        }
        throw RuntimeException("can not find $char")
    }
}