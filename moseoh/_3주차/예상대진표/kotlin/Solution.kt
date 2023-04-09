package _3주차.예상대진표.kotlin

fun main() {
    val N1 = 8
    val A1 = 4
    val B1 = 7
    check(Solution().solution(N1, A1, B1) == 3) { "오답" }
}

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        return Integer.toBinaryString(a - 1 xor b - 1).length
    }
}
