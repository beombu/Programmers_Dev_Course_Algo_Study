package _7주차.주차요금계산.java;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] fees1 = new int[]{180, 5000, 10, 600};
        String[] records1 = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer1 = new int[]{14600, 34400, 5000};
        int[] result1 = new Solution().solution(fees1, records1);
        System.out.printf(
                "테스트 케이스 1: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                Arrays.equals(result1, answer1) ? "정답" : "**오답**", Arrays.toString(result1), Arrays.toString(answer1)
        );

        int[] fees2 = new int[]{120, 0, 60, 591};
        String[] records2 = new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        int[] answer2 = new int[]{0, 591};
        int[] result2 = new Solution().solution(fees2, records2);
        System.out.printf(
                "테스트 케이스 2: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                Arrays.equals(result2, answer2) ? "정답" : "**오답**", Arrays.toString(result2), Arrays.toString(answer2)
        );

        int[] fees3 = new int[]{1, 461, 1, 10};
        String[] records3 = new String[]{"00:00 1234 IN"};
        int[] answer3 = new int[]{14841};
        int[] result3 = new Solution().solution(fees3, records3);
        System.out.printf(
                "테스트 케이스 3: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                Arrays.equals(result3, answer3) ? "정답" : "**오답**", Arrays.toString(result3), Arrays.toString(answer3)
        );
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, List<String>> recordMap = new TreeMap<>();

        for (String record : records) {
            String carNum = record.split(" ")[1];
            String time = record.split(" ")[0];
            List<String> list = recordMap.getOrDefault(carNum, new ArrayList<>());
            list.add(time);
            recordMap.put(carNum, list);
        }

        List<Integer> answer = new ArrayList<>();
        for (String carNum : recordMap.keySet()) {
            answer.add(getCharge(fees, recordMap.get(carNum)));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int getCharge(int[] fees, List<String> record) {
        if (record.size() % 2 == 1) record.add("23:59");
        Collections.sort(record);

        int totalTime = 0;
        for (int i = 0; i < record.size(); i += 2) {
            int time = getMinutes(record.get(i + 1)) - getMinutes(record.get(i));
            totalTime += time;
        }

        int totalCharge = 0;
        if (totalTime == 0) return totalCharge;

        totalTime -= fees[0];
        totalCharge += fees[1];
        if (totalTime <= 0) return totalCharge;


        // 추가 요금
        totalCharge += totalTime / fees[2] * fees[3];
        if (totalTime % fees[2] != 0) {
            totalCharge += fees[3];
        }

        return totalCharge;
    }


    public int getMinutes(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}