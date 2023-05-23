package _11주차.소수_찾기.kotlin

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

    val numbers1 = "17"
    val answer1 = 3
    val result1 = Solution().solution(numbers1)
    printResult(1, result1, answer1)

    val numbers2 = "011"
    val answer2 = 2
    val result2 = Solution().solution(numbers2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(numbers: String): Int {
        return getPermutation(numbers).count(::isPrime)
    }

    private fun getPermutation(numbers: String): Set<Int> {
        val numberSet = mutableSetOf<Int>()

        fun permutation(
            numbers: String,
            number: String,
            depth: Int,
            length: Int,
            visited: BooleanArray = BooleanArray(numbers.length)
        ) {
            if (depth == length) {
                numberSet.add(number.toInt())
                return
            }

            for (i in numbers.indices) {
                if (!visited[i]) {
                    visited[i] = true
                    permutation(numbers, number + numbers[i], depth + 1, length, visited)
                    visited[i] = false
                }
            }
        }

        for (i in numbers.indices) {
            permutation(numbers, "", 0, i + 1)
        }

        return numberSet
    }


    private fun isPrime(number: Int): Boolean {
        if (number == 0 || number == 1) return false
        (2 until number).forEach { if (number % it == 0) return false }
        return true
    }
}