package _4주차.괄호회전하기.kotlin

fun main() {
    val s1 = "[](){}"
    check(Solution().solution(s1) == 3) { "오답" }

    val s2 = "}]()[{"
    check(Solution().solution(s2) == 2) { "오답" }

    val s3 = "[)(]"
    check(Solution().solution(s3) == 0) { "오답" }

    val s4 = "}}}"
    check(Solution().solution(s4) == 0) { "오답" }
}

class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var str = s

        for (i in s.indices) {
            str = str.slice(1 until str.length) + str[0]
            if (isRight(str)) {
                answer++
            }
        }
        return answer
    }

    private fun isRight(str: String): Boolean {
        var s = str
        val regex = Regex("(\\(\\))|(\\{\\})|(\\[\\])")
        while (s.contains(regex)) {
            s = s.replace(regex, "")
        }
        return s.isEmpty()
    }
}
