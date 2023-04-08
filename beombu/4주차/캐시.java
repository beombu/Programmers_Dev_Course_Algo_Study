import java.util.LinkedList;
import java.util.List;

/**
 * L19 : if (cache.size() < cacheSize)에서 너무 많은 시간을 소요했다...
 * Time : O(n^2)
 */
public class 캐시 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String str : cities) {
            str = str.toLowerCase();

            if (cache.size() < cacheSize) {
                if (cache.size() == 0) {
                    cache.add(str);
                    answer += 5;
                    continue;
                }

                for (int i = 0; i < cache.size(); i++) {
                    if (cache.get(i).equals(str)) {
                        cache.remove(i);
                        cache.add(str);
                        answer++;
                        break;
                    }

                    if (i == cache.size() - 1) {
                        cache.add(str);
                        answer += 5;
                        break;
                    }
                }
                continue;
            }

            for (int i = 0; i < cache.size(); i++) {
                if (cache.get(i).equals(str)) {//만약 동일하다면
                    cache.remove(i);
                    cache.add(str);
                    answer++;
                    break;
                }

                if (i == cache.size() - 1) {//마지막까지 찾지 못했다면
                    cache.remove(0);
                    cache.add(str);
                    answer += 5;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //System.out.println(solution(5, new String[]{"leo", "leo", "leo"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }
}
