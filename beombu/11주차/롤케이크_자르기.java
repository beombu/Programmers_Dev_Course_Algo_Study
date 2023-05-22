import java.util.HashMap;
import java.util.HashSet;

/**
 * topping.length = 1,000,000이므로 O(n)으로 풀어야했다..
 * 배열의 어떤 기준점으로 가지고 나누는 경우 미리 map에 값을 넣어둔 뒤
 * 조건을 적용하면 좋은 풀이가 나올 확률이 높다.
 */
public class 롤케이크_자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) - 1);

            if (map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }
            if (set.size() == map.size()) {
                answer++;
            }
        }
        return answer;
    }
}
