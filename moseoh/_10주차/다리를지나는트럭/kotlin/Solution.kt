package _10주차.다리를지나는트럭.kotlin

import java.util.*

fun main() {
    val bridge_length1 = 2
    val weight1 = 10
    val truck_weights1 = intArrayOf(7, 4, 5, 6)
    val answer1 = 8
    val result1 = Solution().solution(bridge_length1, weight1, truck_weights1)
    check(result1 == answer1) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: $result1\n" +
                "\t- 기댓값: $answer1\n"
    }

    val bridge_length2 = 100
    val weight2 = 100
    val truck_weights2 = intArrayOf(10)
    val answer2 = 101
    val result2 = Solution().solution(bridge_length2, weight2, truck_weights2)
    check(result2 == answer2) {
        "\n\n테스트 케이스 2\n" +
                "\t- 실행 결과: $result2\n" +
                "\t- 기댓값: $answer2\n"
    }

    val bridge_length3 = 100
    val weight3 = 100
    val truck_weights3 = intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    val answer3 = 110
    val result3 = Solution().solution(bridge_length3, weight3, truck_weights3)
    check(result3 == answer3) {
        "\n\n테스트 케이스 3\n" +
                "\t- 실행 결과: $result3\n" +
                "\t- 기댓값: $answer3\n"
    }
}

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val truckQueue = truck_weights.map { Truck(it) }.toCollection(LinkedList<Truck>())
        val bridge = Bridge(weight, bridge_length)

        var time = 0
        while (bridge.isNotEmpty() || truckQueue.isNotEmpty()) {
            time++
            bridge.out(time)
            if (truckQueue.isNotEmpty() && bridge.canEnter(truckQueue.peek())) {
                bridge.enter(truckQueue.poll(), time)
            }

        }

        return time
    }

    data class Bridge(
        val weightLimit: Int,
        val length: Int,
        val trucks: Queue<Truck> = LinkedList(),
    ) {
        private var weightCurrent: Int = 0

        fun canEnter(truck: Truck): Boolean {
            return weightCurrent + truck.weight <= weightLimit
        }

        fun enter(truck: Truck, time: Int) {
            truck.onBridge(time)
            trucks.add(truck)
            weightCurrent += truck.weight
        }

        fun out(time: Int) {
            if (trucks.isNotEmpty() && trucks.peek().onBridgeAt + length == time) {
                weightCurrent -= trucks.poll().weight
            }
        }

        fun isNotEmpty(): Boolean = trucks.isNotEmpty()
    }

    data class Truck(
        val weight: Int,
    ) {
        var onBridgeAt: Int = 0
            private set

        fun onBridge(onBridgeAt: Int) {
            this.onBridgeAt = onBridgeAt
        }

    }


}