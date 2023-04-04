package _4주차.H_Index.H_Index

fun main() {
    val citations1 = intArrayOf(3, 0, 6, 1, 5)
    check(Solution().solution(citations1) == 3) { "오답" }
}

class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        citations.sortDescending()

        for (i in citations.indices) {
            if (i + 1 > citations[i]) break
            answer = i + 1
        }

        return answer
    }
}