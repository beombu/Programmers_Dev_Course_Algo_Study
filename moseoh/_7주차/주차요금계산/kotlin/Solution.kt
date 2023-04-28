package _7주차.주차요금계산.kotlin

fun main() {
    val fees1 = intArrayOf(180, 5000, 10, 600)
    val records1 = arrayOf(
        "05:34 5961 IN",
        "06:00 0000 IN",
        "06:34 0000 OUT",
        "07:59 5961 OUT",
        "07:59 0148 IN",
        "18:59 0000 IN",
        "19:09 0148 OUT",
        "22:59 5961 IN",
        "23:00 5961 OUT"
    )
    val answer1 = intArrayOf(14600, 34400, 5000)
    val result1 = Solution().solution(fees1, records1)
    check(result1.contentEquals(answer1)) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: ${result1.contentToString()}\n" +
                "\t- 기댓값: ${answer1.contentToString()}\n"
    }

    val fees2 = intArrayOf(120, 0, 60, 591)
    val records2 = arrayOf("16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN")
    val answer2 = intArrayOf(0, 591)
    val result2 = Solution().solution(fees2, records2)
    check(result2.contentEquals(answer2)) {
        "\n\n테스트 케이스 2\n" +
                "\t- 실행 결과: ${result2.contentToString()}\n" +
                "\t- 기댓값: ${answer2.contentToString()}\n"
    }

    val fees3 = intArrayOf(1, 461, 1, 10)
    val records3 = arrayOf("00:00 1234 IN")
    val answer3 = intArrayOf(14841)
    val result3 = Solution().solution(fees3, records3)
    check(result3.contentEquals(answer3)) {
        "\n\n테스트 케이스 3\n" +
                "\t- 실행 결과: ${result3.contentToString()}\n" +
                "\t- 기댓값: ${answer3.contentToString()}\n"
    }
}

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        return records
            .groupBy { it.split(" ")[1] }
            .toList().sortedBy { it.first }
            .map { calculateCharge(fees, it.second.toMutableList()) }
            .toIntArray()
    }

    private fun calculateCharge(fees: IntArray, list: MutableList<String>): Int {
        if (list.size % 2 == 1) list.add("23:59 num OUT")
        var totalTime = 0
        for (i in list.indices step 2) {
            totalTime += list[i + 1].split(" ")[0].getMinutes() - list[i].split(" ")[0].getMinutes()
        }

        if (totalTime == 0) return 0

        var totalCoast = 0
        totalTime -= fees[0]
        totalCoast += fees[1]
        if (totalTime <= 0) return totalCoast

        totalCoast += totalTime / fees[2] * fees[3]
        return if (totalTime % fees[2] == 0) totalCoast
        else totalCoast + fees[3]
    }

    private fun String.getMinutes(): Int {
        return this.split(":").let {
            it[0].toInt() * 60 + it[1].toInt()
        }
    }
}