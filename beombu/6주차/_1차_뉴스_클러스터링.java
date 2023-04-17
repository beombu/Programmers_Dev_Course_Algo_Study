import java.util.HashMap;
import java.util.HashSet;

/**
 * 틀린 이유 : set을 사용하였기 때문에 두글자에 대한 갯수를 체크하지 못해 중복된 문자에서 문제 밠생
 */

/**
 * 1. str1 loop(2문자씩)
 *      1-1. 문자인 경우
 *       - 소문자 변환
 *       - 저장소 저장
 *       - 합집합++
 *      1-2. 문자가 아닌 경우
 *       - continue
 *
 * 2. str2 loop(2문자씩)
 *      2-1. 문자인 경우
 *      - 소문자 변환
 *          2-1-1. 저장소에 값이 존재하는 경우
 *          - 교집합++
 *          2-1-2. 저장소에 값이 존재하지 않는 경우
 *          - 저장소 저장
 *          - 합집합++
 *      2-2. 문자가 아닌 경우
 *      - continue
 */
public class _1차_뉴스_클러스터링 {
    public static int solution(String str1, String str2) {
        int intersection = 0;//교집합
        int combination = 0;//합집합
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);

            if (isAlphabet(ch1, ch2)) {
                String str = Character.toString(Character.toLowerCase(ch1))
                        + Character.toString(Character.toLowerCase(ch2));
                System.out.println("1 " + str);

                set.add(str);
                combination++;
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);

            if (isAlphabet(ch1, ch2)) {
                String str = Character.toString(Character.toLowerCase(ch1))
                        + Character.toString(Character.toLowerCase(ch2));

                System.out.println("2 " + str);

                if (set.contains(str)) {
                    intersection++;
                } else {
                    set.add(str);
                    combination++;
                }
            }
        }

        double answer = 0;
        if (set.size() == 0) {
            answer = 1;
        } else if (set.size() == 1) {
            answer = (double) Math.min(intersection, combination) / (double) Math.max(intersection, combination);
        } else {
            answer = (double) intersection / (double) combination;
        }

        System.out.println(intersection);
        System.out.println(combination);

        return (int) (answer * 65536);
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
