import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {

    // 엣지 케이스
    // 1. 출차가 안된 경우
    // 2. 입차와 출차를 여러 번 한 경우
    // 3. 기본 시간만큼 정확하게 진행한 경우
    public int[] solution(int[] fees, String[] records) {
        // 1 ≤ fees[0] ≤ 1,439
        int 기본시간 = fees[0];
        // 0 ≤ fees[1] ≤ 100,000
        int 기본요금 = fees[1];
        // 1 ≤ fees[2] ≤ 1,439
        int 단위시간 = fees[2];
        // 1 ≤ fees[3] ≤ 10,000
        int 단위요금 = fees[3];
        // 마지막 출차 시간
        int 마지막_출차시간 = 시간_구하자("23:59");

        Map<String, Queue<Integer>> cars = 입차_출차_정보(records);

        List<Integer> answer = cars.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(entry -> {
            Queue<Integer> value = entry.getValue();
            int 기간 = 0;

            while (!value.isEmpty()) {
                int 입차 = value.poll();
                if (value.isEmpty()) {
                    기간 += 마지막_출차시간 - 입차;
                    break;
                }
                int 출차 = value.poll();
                기간 += 출차 - 입차;
            }

            return 요금_구하자(기간, 기본시간, 기본요금, 단위시간, 단위요금);
        }).collect(Collectors.toList());

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private Map<String, Queue<Integer>> 입차_출차_정보(String[] records) {
        Map<String, Queue<Integer>> cars = new HashMap<>();
        for (String record : records) {
            String[] arr = record.split(" ");
            int time = 시간_구하자(arr[0]);
            String name = arr[1];
            if (cars.containsKey(name)) {
                cars.get(name).add(time);
            } else {
                Queue<Integer> q = new PriorityQueue<>();
                q.add(time);
                cars.put(name, q);
            }
        }
        return cars;
    }

    private int 시간_구하자(String time) {
        String arr[] = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);
        return hour * 60 + minute;
    }

    private int 요금_구하자(int 기간, int 기본시간, int 기본요금, int 단위시간, int 단위요금) {
        if (기간 <= 기본시간) {
            return 기본요금;
        }

        return 기본요금 + (int) Math.ceil((double) (기간 - 기본시간) / 단위시간) * 단위요금;
    }
}
