import java.util.HashMap;

public class _1차_뉴스_클러스터링 {
    public static int solution(String str1, String str2) {
        double intersection = 0;//교집합
        double combination = 0;//합집합
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);

            if (isAlphabet(ch1, ch2)) {
                String str = addChar(ch1, ch2);
                map1.put(str, map1.getOrDefault(str, 0) + 1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);

            if (isAlphabet(ch1, ch2)) {
                String str = addChar(ch1, ch2);
                map2.put(str, map2.getOrDefault(str, 0) + 1);
            }
        }

        if (map1.size() == 0 && map2.size() == 0) {
            return 65536;
        }

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
                combination += Math.max(map1.get(key), map2.get(key));
                map2.remove(key);
            } else {
                combination += map1.get(key);
            }
        }

        for (String key : map2.keySet()) {
            combination += map2.get(key);
        }

        return (int) Math.floor((intersection / combination) * 65536);
    }

    private static String addChar(char ch1, char ch2) {
        return Character.toString(Character.toLowerCase(ch1))
                + Character.toString(Character.toLowerCase(ch2));
    }

    private static boolean isAlphabet(char ch1, char ch2) {
        return Character.isLetter(ch1) && Character.isLetter(ch2);
    }

    public static void main(String[] args) {
        //System.out.println(solution("FRANCE", "french"));
        //System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("abab", "baba"));
    }
}
