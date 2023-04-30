package src._7주차;

import java.util.*;

public class 주차요금계산 {

    /**
     * 출차 내역이 없다면 23:59로 간주
     * 초과 시간이 단위 시간으로 나누어 떨어지지 않으면 올림
     *
     * @param fees    : 기본시간, 기본요금, 단위시간(분), 단위요금
     * @param records : "시간 차번호 IN/OUT"
     * @return : 차량 번호가 작은 자동차부터 청구할 주차 요금 반환
     */
    public static int[] solution(int[] fees,
                                 String[] records) {

        Map<String, String> recordMap = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();

        for (int i = 0; i < records.length; i++) {

            String[] record = records[i].split(" ");

            if (!recordMap.containsKey(record[1])) {
                recordMap.put(record[1], record[0]);
                continue;
            }

            int carTime = outputCar(recordMap.get(record[1]), record[0]);

            timeMap.put(record[1], timeMap.getOrDefault(record[1], 0) + carTime);
            recordMap.remove(record[1]);
        }

        for (String carNumber : recordMap.keySet()) {
            int carTime = outputCar(recordMap.get(carNumber), "23:59");

            timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + carTime);
        }

        List<Map.Entry<String, Integer>> timeEntry = new ArrayList<>(timeMap.entrySet());
        Collections.sort(timeEntry, Comparator.comparingInt(o -> Integer.parseInt(o.getKey())));

        int[] answer = new int[timeEntry.size()];
        int i = 0;

        for (Map.Entry<String, Integer> entry : timeEntry) {

            answer[i++] = getFee(entry.getValue(), fees);
        }

        return answer;
    }

    private static int getFee(int totalTime,
                              int[] fees) {

        int useTime = totalTime - fees[0];

        return useTime <= 0 ?
                fees[1] :
                useTime % fees[2] == 0 ?
                        fees[1] + useTime / fees[2] * fees[3] :
                        fees[1] + (useTime / fees[2] + 1) * fees[3];
    }

    private static int outputCar(String inputTime,
                                 String outputTime) {

        StringTokenizer stringTokenizer1 = new StringTokenizer(inputTime, ":");
        StringTokenizer stringTokenizer2 = new StringTokenizer(outputTime, ":");

        int[] input = new int[]{
                Integer.parseInt(stringTokenizer1.nextToken()),
                Integer.parseInt(stringTokenizer1.nextToken())
        };

        int[] output = new int[]{
                Integer.parseInt(stringTokenizer2.nextToken()),
                Integer.parseInt(stringTokenizer2.nextToken())
        };

        return input[1] < output[1] ?
                (output[0] - input[0]) * 60 + (output[1] - input[1]) :
                (output[0] - input[0] - 1) * 60 + (60 + output[1] - input[1]);
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{180, 5000, 10, 600};
        String[] arr2 = new String[]{
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };

        int[] answer = solution(arr1, arr2);

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
