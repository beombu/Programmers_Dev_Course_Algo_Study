import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 주차_요금_계산 {
    public final static String MAX_TIME = "23:59";

    public int[] solution(int[] fees, String[] records) {
        //key : 차량번호, value : 입차 시간
        HashMap<String, Integer> parkingCars = new HashMap<>();
        //key : 차량번호, value : 누적 주차 시간
        HashMap<String, Integer> parkingTimes = new HashMap<>();
        ArrayList<String> cars = new ArrayList<>();

        for (String record : records) {
            String[] rc = record.split(" ");

            int time = getMinute(rc[0]);
            String carNum = rc[1];
            String breakdown = rc[2];

            if (!cars.contains(carNum)) {
                cars.add(carNum);
                parkingTimes.put(carNum, 0);
            }

            if (parkingCars.containsKey(carNum)) {
                parkingTimes.put(carNum, parkingTimes.get(carNum) + (time - parkingCars.get(carNum)));
                parkingCars.remove(carNum);
            } else {
                parkingCars.put(carNum, time);
            }
        }

        return getFees(fees, parkingCars, parkingTimes, cars);
    }

    private int[] getFees(int[] fees, HashMap<String, Integer> parkingCars, HashMap<String, Integer> parkingTimes, ArrayList<String> cars) {
        Collections.sort(cars);
        int[] answer = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            answer[i] = fees[1];
            String car = cars.get(i);
            int plusTime = parkingTimes.get(car) - fees[0];

            if (parkingCars.containsKey(car)) {
                plusTime += getMinute(MAX_TIME) - parkingCars.get(car);
            }

            if (plusTime > 0) {
                answer[i] += Math.ceil(plusTime / (fees[2] * 1.0)) * fees[3];
            }
        }

        return answer;
    }

    private int getMinute(String time) {
        String[] str = time.split(":");

        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}
