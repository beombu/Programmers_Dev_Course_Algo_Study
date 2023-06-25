package _15주차.마법의_엘리베이터

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

    val storey1 = 16
    val answer1 = 6
    val result1 = Solution().solution(storey1)
    printResult(1, result1, answer1)

    val storey2 = 2554
    val answer2 = 16
    val result2 = Solution().solution(storey2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(storey: Int): Int {
        var num = storey.toString().toInt()
        var sum = 0

        while (num != 0) {
            val n = num % 10
            num /= 10
            val nextN = num % 10

            if ((n + nextN >= 10 && n >= 5) || n > 5) {
                sum += 10 - n
                num += 1
            } else {
                sum += n
            }
        }

        return sum
    }
}