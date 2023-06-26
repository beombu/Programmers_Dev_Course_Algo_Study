package _16주차.혼자_놀기의_달인

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

    val cards1 = intArrayOf(8, 6, 3, 7, 2, 5, 1, 4)
    val answer1 = 12
    val result1 = Solution().solution(cards1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(cards: IntArray): Int {
        val groups = mutableListOf<Int>()
        val isVisited = BooleanArray(cards.size)

        for (i in cards.indices) {
            var index = i
            var count = 0;
            while (!isVisited[index]) {
                isVisited[index] = true
                count++
                index = cards[index] - 1
            }
            groups.add(count)
        }

        return groups.sortedDescending().let {
            it[0] * it[1]
        }
    }
}