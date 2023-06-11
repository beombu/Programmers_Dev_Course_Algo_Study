package _13주차.메뉴_리뉴얼.java;

import java.util.*;

class Solution {
    Map<String, Integer> map;
    List<String> combineList;

    public static void main(String[] args) {
        String[] orders1 = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = new int[]{2, 3, 4};
        String[] answer1 = new String[]{"AC", "ACDE", "BCFG", "CDE"};
        String[] result1 = new Solution().solution(orders1, course1);
        PRINT_RESULT(1, result1, answer1);

        String[] orders2 = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = new int[]{2, 3, 5};
        String[] answer2 = new String[]{"ACD", "AD", "ADE", "CD", "XYZ"};
        String[] result2 = new Solution().solution(orders2, course2);
        PRINT_RESULT(2, result2, answer2);

        String[] orders3 = new String[]{"XYZ", "XWY", "WXA"};
        int[] course3 = new int[]{2, 3, 4};
        String[] answer3 = new String[]{"WX", "XY"};
        String[] result3 = new Solution().solution(orders3, course3);
        PRINT_RESULT(3, result3, answer3);
    }

    public static void PRINT_RESULT(int index, String[] result, String[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        List<String> answer = new ArrayList<>();

        // 모든 조합 구하기
        for (String order : orders) {
            combineList = new ArrayList<>();
            for (int c : course) {
                combine(order, c, 0, "");
            }

            for (String combine : combineList) {
                int count = map.getOrDefault(combine, 0);
                map.put(combine, count + 1);
            }
        }

        // 각 코스 최댓값 구하기
        int[] maxArr = new int[11];
        Arrays.fill(maxArr, Integer.MIN_VALUE);

        for (int c : course) {
            for (String key : map.keySet()) {
                if (key.length() == c) {
                    maxArr[c] = Math.max(maxArr[c], map.get(key));
                }
            }
        }

        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count >= 2 && maxArr[key.length()] == count) {
                answer.add(key);
            }
        }

        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }


    private void combine(String str, int length, int index, String result) {
        if (result.length() == length) {
            char[] chars = result.toCharArray();
            Arrays.sort(chars);
            combineList.add(new String(chars));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            combine(str, length, i + 1, result + str.charAt(i));
        }
    }
}