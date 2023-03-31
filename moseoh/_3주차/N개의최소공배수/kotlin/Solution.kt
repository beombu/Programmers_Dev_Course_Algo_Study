package _3주차.N개의최소공배수.kotlin

fun main() {
    val arr1 = intArrayOf(2, 6, 8, 14)
    check(Solution().solution2(arr1) == 168) { "오답" }

    val arr2 = intArrayOf(1, 2, 3)
    check(Solution().solution2(arr2) == 6) { "오답" }
}

class Solution {
    fun solution2(arr: IntArray): Int {
        var answer = 2
        while (arr.sumOf { answer % it } != 0) {
            answer++
        }
        return answer
    }

    fun solution(arr: IntArray): Int {
        var index = 2
        var answer = 1

        while (arr.sum() != arr.size) {
            var include = false
            for (i in arr.indices) {
                if (arr[i] != 1 && arr[i] % index == 0) {
                    arr[i] /= index
                    include = true
                }
            }

            if (include) {
                answer *= index
            } else {
                index++
            }
        }

        return answer
    }
}
