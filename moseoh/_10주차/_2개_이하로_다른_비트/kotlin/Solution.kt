package _10주차._2개_이하로_다른_비트.kotlin

fun main() {
    fun printResult(index: Int, result: LongArray, answer: LongArray) {
        val correct = result.contentEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val numbers1 = longArrayOf(2L, 7L, 8L, 1000L, 5L)
    val answer1 = longArrayOf(3L, 11L, 9L, 1001L, 6L)
    val result1 = Solution().solution(numbers1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(numbers: LongArray): LongArray {
        fun getNum(num: Long): Long {
            if (num % 2L == 0L) return num + 1

            val binary = num.toString(2)
            if (!binary.contains('0')) return num - num.inv().shr(1)

            val index = binary.indexOfLast { it == '0' }
            return StringBuilder(binary).also {
                it.setCharAt(index, '1')
                it.setCharAt(index + 1, '0')
            }.toString().toLong(2)
        }
        return numbers.map { getNum(it) }.toLongArray()
    }
}