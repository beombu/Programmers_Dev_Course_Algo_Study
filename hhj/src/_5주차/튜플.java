package src._5주차;

import java.util.*;
import java.util.stream.Collectors;

public class 튜플 {

    /**
     * 튜플 성질
     * - 중복 원소 가능
     * - 순서가 다르면 다른 튜플
     * - 원소 개수 유한
     * 원소 개수가 n인 중복 원소가 없는 튜플 제공
     *
     * @param s : 특정 튜플을 표현하는 집합이 담긴 문자열
     * @return : s가 표현하는 튜플을 배열로 반환
     */
    public static int[] solution(String s) {

        s = s.substring(2);
        s = s.substring(0, s.length() - 2);

        List<String> list = Arrays.stream(s.split("},\\{"))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        int i = 0;
        int[] answer = new int[list.size()];
        Set<Integer> set = new HashSet<>();

        for (String result : list) {

            StringTokenizer stringTokenizer = new StringTokenizer(result, ",");

            while (stringTokenizer.hasMoreTokens()) {

                int temp = Integer.parseInt(stringTokenizer.nextToken());

                if (!set.contains(temp))
                    answer[i++] = temp;

                set.add(temp);
            }
        }

        return answer;
    }
}
