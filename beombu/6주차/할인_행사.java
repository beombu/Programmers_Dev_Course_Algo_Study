import java.util.HashMap;

public class 할인_행사 {
    public static final int MEMBERSHIP_DATE = 10;

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - MEMBERSHIP_DATE + 1; i++) {
            int sum = 0;
            HashMap<String, Integer> cloneMap = (HashMap<String, Integer>) map.clone();

            for (int j = i; j < i + MEMBERSHIP_DATE; j++) {
                if (cloneMap.containsKey(discount[j]) && cloneMap.get(discount[j]) != 0) {
                    cloneMap.put(discount[j], cloneMap.get(discount[j]) - 1);
                }
            }

            if (isVisitShop(sum, cloneMap)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isVisitShop(int sum, HashMap<String, Integer> cloneMap) {
        for (String key : cloneMap.keySet()) {
            if (cloneMap.get(key) != 0) {
                return false;
            }
            sum += cloneMap.get(key);
        }

        return sum == 0;
    }
}
