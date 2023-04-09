import java.util.*;

/**
 * Time : O(n log n)
 */
public class 귤_고르기 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : tangerine) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hashMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        /*
        hashMap의 Value 정렬에 관련된 더 좋은 코드들

        List<Integer> list = new ArrayList<>(hashMap.keySet());
        list.sort((o1, o2) -> hashMap.get(o2)-hashMap.get(o1));

        --

        List<Map.Entry<Integer, Integer>> collect =
                         hashMap.entrySet()
                        .stream()
                        .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                        .collect(Collectors.toList());
         */

        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (k - entry.getValue() <= 0) {
                answer++;
                break;
            }

            k -= entry.getValue();
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 3, 3}));
    }
}
