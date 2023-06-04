package _12주차.기능개발.kotlin

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

    val progresses1 = intArrayOf(93, 30, 55)
    val speeds1 = intArrayOf(1, 30, 5)
    val answer1 = intArrayOf(2, 1)
    val result1 = Solution().solution(progresses1, speeds1)
    printResult(1, result1, answer1)

    val progresses2 = intArrayOf(95, 90, 99, 99, 80, 99)
    val speeds2 = intArrayOf(1, 1, 1, 1, 1, 1)
    val answer2 = intArrayOf(1, 3, 2)
    val result2 = Solution().solution(progresses2, speeds2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val dayArray = progresses.mapIndexed { index, i ->
            (100 - i) / speeds[index] + if ((100 - i) % speeds[index] != 0) 1 else 0
        }.toIntArray()

        for (i in dayArray.indices) {
            if (i == 0) continue

            if (dayArray[i] < dayArray[i - 1]) {
                dayArray[i] = dayArray[i - 1]
            }
        }

        return dayArray.groupBy { it }.map { it.value.size }.toIntArray()
    }
}