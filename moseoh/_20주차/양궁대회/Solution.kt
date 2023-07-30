package _20주차.양궁대회

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

    val n1 = 5
    val info1 = intArrayOf(2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0)
    val answer1 = intArrayOf(0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0)
    val result1 = Solution().solution(n1, info1)
    printResult(1, result1, answer1)

    val n2 = 1
    val info2 = intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val answer2 = intArrayOf(-1)
    val result2 = Solution().solution(n2, info2)
    printResult(2, result2, answer2)

    val n3 = 9
    val info3 = intArrayOf(0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1)
    val answer3 = intArrayOf(1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0)
    val result3 = Solution().solution(n3, info3)
    printResult(3, result3, answer3)

    val n4 = 10
    val info4 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3)
    val answer4 = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2)
    val result4 = Solution().solution(n4, info4)
    printResult(4, result4, answer4)
}

class Solution {
    var max = -55
    var result = IntArray(11) { 0 }

    fun solution(n: Int, info: IntArray): IntArray {
        max = -55
        result = IntArray(11) { 0 }
        recursiveFunction(n, n, 0, 0, 0, result, info)
        return if (max <= 0) intArrayOf(-1)
        else result
    }

    private fun recursiveFunction(
        n: Int,
        left: Int,
        myScore: Int,
        rivalScore: Int,
        index: Int,
        current: IntArray,
        info: IntArray
    ) {
        if (index == 10) {
            val temp = current.clone()
            temp[index] += left
            if (max < myScore - rivalScore) {
                max = myScore - rivalScore
                result = temp
            } else if (max == myScore - rivalScore) {
                for (i in 10 downTo 0) {
                    if (result[i] < temp[i]) result = temp
                    else if (result[i] > temp[i]) break
                }
            }
            return
        }
        val need = info[index] + 1
        val score = 10 - index

        if (left >= need) {
            val myNextScore = myScore + score
            current[index] += need
            recursiveFunction(n, left - need, myNextScore, rivalScore, index + 1, current, info)
            current[index] -= need
        }

        val rivalNextScore = if (info[index] == 0) rivalScore else rivalScore + score
        recursiveFunction(n, left, myScore, rivalNextScore, index + 1, current, info)
    }
}
