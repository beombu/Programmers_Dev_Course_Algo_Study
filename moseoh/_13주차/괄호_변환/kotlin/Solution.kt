package _13주차.괄호_변환.kotlin

import java.util.*
import java.util.stream.Collectors

fun main() {
    fun printResult(index: Int, result: String, answer: String) {
        val correct = result == answer
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val p1 = "(()())()"
    val answer1 = "(()())()"
    val result1 = Solution().solution(p1)
    printResult(1, result1, answer1)

    val p2 = ")("
    val answer2 = "()"
    val result2 = Solution().solution(p2)
    printResult(2, result2, answer2)

    val p3 = "()))((()"
    val answer3 = "()(())()"
    val result3 = Solution().solution(p3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(p: String): String {
        val result = java.lang.StringBuilder()
        val v: Queue<Char> = p.chars()
            .mapToObj { c: Int -> c.toChar() }
            .collect(Collectors.toCollection { LinkedList() })
        run(v, result)
        return result.toString()
    }

    private fun run(v: Queue<Char>, result: java.lang.StringBuilder) {
        val u: Queue<Char> = LinkedList()
        while (!v.isEmpty()) {
            var left = 0
            var right = 0
            while (left == 0 || right == 0 || left != right) {
                val c = v.poll()
                u.add(c)
                if (c == '(') left++ else right++
            }
            if (isRightBracket(u)) {
                result.append(queueToString(u))
            } else {
                result.append('(')
                run(v, result)
                result.append(')')
                result.append(queueToString(changeBracket(u)))
            }
        }
    }

    private fun queueToString(chars: Queue<Char>): String? {
        val result = java.lang.StringBuilder()
        while (!chars.isEmpty()) {
            result.append(chars.poll())
        }
        return result.toString()
    }

    private fun isRightBracket(chars: Queue<Char>): Boolean {
        var count = 0
        for (c in chars) {
            if (c == '(') count++ else count--
            if (count < 0) return false
        }
        return count == 0
    }

    private fun changeBracket(chars: Queue<Char>): Queue<Char> {
        val result: Queue<Char> = LinkedList()
        val array = chars.toTypedArray()
        for (i in 1 until array.size - 1) {
            if (array[i] == '(') result.add(')') else result.add('(')
        }
        chars.clear()
        return result
    }
}