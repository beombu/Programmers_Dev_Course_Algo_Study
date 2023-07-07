package _17주차.후보키

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

    val relation1 = arrayOf(
        arrayOf("100", "ryan", "music", "2"),
        arrayOf("200", "apeach", "math", "2"),
        arrayOf("300", "tube", "computer", "3"),
        arrayOf("400", "con", "computer", "4"),
        arrayOf("500", "muzi", "music", "3"),
        arrayOf("600", "apeach", "music", "2")
    )
    val answer1 = 2
    val result1 = Solution().solution(relation1)
    printResult(1, result1, answer1)

    val relation2 = arrayOf(
        arrayOf("a", "1", "aaa", "c", "ng"),
        arrayOf("a", "1", "bbb", "e", "g"),
        arrayOf("c", "1", "aaa", "d", "ng"),
        arrayOf("d", "2", "bbb", "d", "ng")
    )
    val answer2 = 5
    val result2 = Solution().solution(relation2)
    printResult(2, result2, answer2)

}

class Solution {
    private lateinit var isVisited: BooleanArray
    private lateinit var uniqueSet: MutableSet<IntArray>
    private lateinit var indexList: MutableList<IntArray>

    fun solution(relation: Array<Array<String>>): Int {
        val columnSize = relation[0].size
        isVisited = BooleanArray(columnSize)
        uniqueSet = mutableSetOf()
        indexList = mutableListOf()

        combination(columnSize)

        var answer = 0
        indexList.forEach { arr ->
            if (isUnique(arr, relation)) {
                uniqueSet.add(arr)
                answer++
            }
        }

        return answer
    }

    private fun combination(size: Int) {
        fun backtracking(list: List<Int>, index: Int, length: Int, result: MutableList<Int>) {
            if (result.size == length) {
                indexList.add(result.toIntArray())
                return
            }

            for (i in index until list.size) {
                isVisited[i] = true
                result.add(i)
                backtracking(list, i + 1, length, result)
                result.removeLast()
                isVisited[i] = false
            }
        }

        val list: List<Int> = List(size) { it + 1 }
        for (i in 1..list.size) {
            backtracking(list, 0, i, mutableListOf())
        }
    }

    private fun isUnique(indexArray: IntArray, relation: Array<Array<String>>): Boolean {
        for (arr in uniqueSet) {
            if (indexArray.toList().containsAll(arr.toList())) return false

        }

        val set = mutableSetOf<String>()

        relation.forEach {
            set.add(it.filterIndexed { index, _ -> index in indexArray }.joinToString(""))
        }

        return set.size == relation.size
    }
}