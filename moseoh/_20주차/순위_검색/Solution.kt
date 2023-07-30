package _20주차.순위_검색

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

    val info1 = arrayOf(
        "java backend junior pizza 150",
        "python frontend senior chicken 210",
        "python frontend senior chicken 150",
        "cpp backend senior pizza 260",
        "java backend junior chicken 80",
        "python backend senior chicken 50"
    )
    val query1 = arrayOf(
        "java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150",
        "- and - and - and chicken 100",
        "- and - and - and - 150"
    )
    val answer1 = intArrayOf(1, 1, 1, 1, 2, 4)
    val result1 = Solution().solution(info1, query1)
    printResult(1, result1, answer1)
}

//class Solution {
//    fun solution(info: Array<String>, query: Array<String>): IntArray {
//        val applicants = info.map {
//            val split = it.split(" ")
//            Applicant(split[0], split[1], split[2], split[3], split[4].toInt())
//        }
//
//        val queries = query.map { s ->
//            val split = s.replace(" and ", " ").split(" ")
//            val strings = split.take(4).map { if (it == "-") null else it }
//            val score = split.last().toInt()
//            Query(strings[0], strings[1], strings[2], strings[3], score)
//        }
//
//        return queries.map { q -> applicants.count { it.matches(q) } }.toIntArray()
//    }
//
//    private fun Applicant.matches(query: Query): Boolean {
//        return (query.language?.let { it == this.language } ?: true) &&
//                (query.position?.let { it == this.position } ?: true) &&
//                (query.career?.let { it == this.career } ?: true) &&
//                (query.soulFood?.let { it == this.soulFood } ?: true) &&
//                (query.score?.let { it <= this.score } ?: true)
//    }
//
//    data class Applicant(
//        val language: String,
//        val position: String,
//        val career: String,
//        val soulFood: String,
//        val score: Int,
//    )
//
//    data class Query(
//        val language: String?,
//        val position: String?,
//        val career: String?,
//        val soulFood: String?,
//        val score: Int?,
//    )
//}

class Solution {
    val map = HashMap<String, MutableList<Int>>()

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)
        info.forEach { dfs("", 0, it.split(" ").toTypedArray()) }
        map.values.forEach { it.sort() }

        for (i in query.indices) {
            val str = query[i].replace(" and ", "").split(" ")
            answer[i] = search(str[0], str[1].toInt())
        }
        return answer
    }

    private fun dfs(key: String, depth: Int, row: Array<String>) {
        if (depth == 4) {
            if (map.containsKey(key)) map[key]!!.add(row[depth].toInt())
            else map[key] = mutableListOf(row[depth].toInt())
            return
        }
        dfs("$key-", depth + 1, row)
        dfs("$key${row[depth]}", depth + 1, row)
    }

    private fun search(key: String, score: Int): Int {
        if (!map.containsKey(key)) return 0
        var start = 0
        var end = map[key]!!.size - 1
        while (start <= end) {
            val mid = (start + end) / 2
            if (map[key]!![mid] < score) start = mid + 1
            else end = mid - 1
        }
        return map[key]!!.size - start
    }
}