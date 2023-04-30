import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = initialize();
        int size = map.size();

        List<Integer> list = new ArrayList<>();

        while (!msg.isBlank()) {
            int cur = 0;
            int lst = msg.length();

            while (true) {
                String w = msg.substring(cur, lst);
                if (map.containsKey(w)) {
                    list.add(map.get(w));
                    if (lst < msg.length()) {
                        map.put(w + msg.charAt(lst), ++size);
                    }
                    break;
                } else {
                    lst--;
                }
            }
            msg = msg.substring(lst);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Map<String, Integer> initialize() {
        int a = 'A';
        String strs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            char at = strs.charAt(i - 1);
            map.put(String.valueOf(at), at - a + 1);
        }
        return map;
    }

}
