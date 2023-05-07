package _8주차.오픈채팅방.java;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] record1 = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] answer1 = new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        String[] result1 = new Solution().solution(record1);
        System.out.printf(
                "테스트 케이스 1: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                Arrays.equals(result1, answer1) ? "정답" : "**오답**", Arrays.toString(result1), Arrays.toString(answer1)
        );
    }

    public String[] solution(String[] record) {
        List<String> recordList = new ArrayList<>();
        Map<String, String> nameMap = new HashMap<>();
        for (String s : record) {
            if (!s.startsWith("Leave")) {
                String[] split = s.split(" ");
                nameMap.put(split[1], split[2]);
            }

            if (!s.startsWith("Change")) {
                recordList.add(s);
            }
        }

        int length = recordList.size();
        String[] answer = new String[length];
        for (int i = 0; i < length; i++) {
            String[] split = recordList.get(i).split(" ");
            answer[i] = nameMap.get(split[1]);
            if ("Enter".equals(split[0])) {
                answer[i] += "님이 들어왔습니다.";
            } else {
                answer[i] += "님이 나갔습니다.";
            }
        }

        return answer;
    }
}