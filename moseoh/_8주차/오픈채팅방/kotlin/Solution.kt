package _8주차.오픈채팅방.kotlin

fun main() {
    val record1 = arrayOf(
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    )
    val answer1 = arrayOf("Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다.")
    val result1 = Solution().solution(record1)
    check(result1.contentEquals(answer1)) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: ${result1.contentToString()}\n" +
                "\t- 기댓값: ${answer1.contentToString()}\n"
    }
}

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val users = hashMapOf<String, String>()
        val accessRecord = mutableListOf<Pair<Action, String>>()

        record.forEach {
            val split = it.split(" ")
            when (Action.valueOf(split[0])) {
                Action.Change -> {
                    val uuid = split[1]
                    val nickname = split[2]
                    users[uuid] = nickname
                }

                Action.Enter -> {
                    val uuid = split[1]
                    val nickname = split[2]
                    users[uuid] = nickname

                    accessRecord.add(Pair(Action.Enter, uuid))
                }

                Action.Leave -> {
                    val uuid = split[1]

                    accessRecord.add(Pair(Action.Leave, uuid))
                }
            }
        }

        return accessRecord.map {
            users[it.second] + it.first.message
        }.toTypedArray()
    }

    enum class Action(val message: String) {
        Enter("님이 들어왔습니다."),
        Leave("님이 나갔습니다."),
        Change("");
    }
}