package _15주차.호텔_대실

import java.time.LocalTime
import java.time.format.DateTimeFormatter

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

    val book_time1 = arrayOf(
        arrayOf("15:00", "17:00"),
        arrayOf("16:40", "18:20"),
        arrayOf("14:20", "15:20"),
        arrayOf("14:10", "19:20"),
        arrayOf("18:20", "21:20")
    )
    val answer1 = 3
    val result1 = Solution().solution(book_time1)
    printResult(1, result1, answer1)

    val book_time2 = arrayOf(arrayOf("09:10", "10:10"), arrayOf("10:20", "12:20"))
    val answer2 = 1
    val result2 = Solution().solution(book_time2)
    printResult(2, result2, answer2)

    val book_time3 = arrayOf(arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30"))
    val answer3 = 3
    val result3 = Solution().solution(book_time3)
    printResult(3, result3, answer3)
}


class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val list = mutableListOf<LocalTime>()
        book_time.sortBy { LocalTime.parse(it[0]).hour * 60 + LocalTime.parse(it[0]).minute }

        for (i in book_time.indices) {
            val startTime = LocalTime.parse(book_time[i][0], formatter)
            var endTime = LocalTime.parse(book_time[i][1], formatter).plusMinutes(10)
            if (endTime.isBefore(LocalTime.parse("00:10"))) endTime = LocalTime.parse("23:59", formatter)

            val index = list.indexOfFirst { !startTime.isBefore(it) }
            if (index != -1) list.removeAt(index)
            list.add(endTime)
        }
        return list.size
    }
}