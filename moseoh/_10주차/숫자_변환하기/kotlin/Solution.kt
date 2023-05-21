package _10주차.숫자_변환하기.kotlin


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

    val x1 = 10
    val y1 = 40
    val n1 = 5
    val answer1 = 2
    val result1 = Solution().solution(x1, y1, n1)
    printResult(1, result1, answer1)

    val x2 = 10
    val y2 = 40
    val n2 = 30
    val answer2 = 1
    val result2 = Solution().solution(x2, y2, n2)
    printResult(2, result2, answer2)

    val x3 = 2
    val y3 = 5
    val n3 = 4
    val answer3 = -1
    val result3 = Solution().solution(x3, y3, n3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        return IntArray(y + 1) { -1 }.apply {
            this[x] = 0
            for (i in x + 1..y) {
                this[i] = listOfNotNull(
                    if (i % 3 == 0 && this[i / 3] != -1) this[i / 3] + 1 else null,
                    if (i % 2 == 0 && this[i / 2] != -1) this[i / 2] + 1 else null,
                    if (i - n >= x && this[i - n] != -1) this[i - n] + 1 else null
                ).minOrNull() ?: -1
            }
        }[y]
    }
}
