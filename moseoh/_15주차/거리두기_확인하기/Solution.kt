package _15주차.거리두기_확인하기

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

//    val places1 = arrayOf(
//        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
//        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
//        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
//        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
//        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
//        arrayOf("OOPOO", "OOOOO", "OOPOO", "OOOOO", "OOOOO")
//    )
//    val answer1 = intArrayOf(1, 0, 1, 1, 1, 0)
    val places1 = arrayOf(
        arrayOf("OOPOO", "OOOOO", "OOPOO", "OOOOO", "OOOOO")
    )
    val answer1 = intArrayOf(0)
    val result1 = Solution().solution(places1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        return places.map { checkPlace(it) }.toIntArray()
    }

    private fun checkPlace(place: Array<String>): Int {
        for (i in place.indices) {
            for (j in place[i].indices) {
                if (place[i][j] == 'P' && !check(i, j, place)) {
                    return 0
                }
            }
        }
        return 1
    }

    private fun check(x: Int, y: Int, place: Array<String>, excludeIndex: Int? = null): Boolean {
        for (i in direction.indices) {
            if (excludeIndex == i) continue

            val x1 = x + direction[i][0]
            val y1 = y + direction[i][1]
            println("$x1, $y1, $excludeIndex")
            if (!isRange(x1, y1, place)) continue
            if (place[x1][y1] == 'X') continue
            if (place[x1][y1] == 'P') return false
            if (excludeIndex == null && !check(x1, y1, place, (i + 2) % 4)) return false
        }
        return true
    }

    private fun isRange(indexX: Int, indexY: Int, place: Array<String>): Boolean {
        return indexX >= 0 && indexX < place.size && indexY >= 0 && indexY < place[0].length
    }

    private val direction = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
    )
}