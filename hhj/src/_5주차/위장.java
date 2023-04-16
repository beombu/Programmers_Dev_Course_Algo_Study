package src._5주차;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

    /**
     * clothes의 각 행은 의상 이름, 의상 종류로 이루어짐
     *
     * @param clothes : 스파이가 가진 의상들
     * @return : 서로 다른 조합수
     */
    public static int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;

        for(Integer i : map.values()){
            answer *= i+1;
        }

        return answer-1;
    }

    public static void main(String[] args) {
        String[][] s = new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution(s));
    }
}
