package _7주차._3차압축.java;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String msg1 = "KAKAO";
        int[] answer1 = new int[]{11, 1, 27, 15};
        int[] result1 = new Solution().solution(msg1);
        System.out.printf(
                "테스트 케이스 1: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                Arrays.equals(result1, answer1) ? "정답" : "**오답**", Arrays.toString(result1), Arrays.toString(answer1)
        );

        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        int[] answer2 = new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34};
//        int[] result2 = new Solution().solution(msg2);
//        System.out.printf(
//                "테스트 케이스 2: %s\n" +
//                        "\t- 실행 결과: %s\n" +
//                        "\t- 기댓값: %s\n\n",
//                Arrays.equals(result2, answer2) ? "정답" : "**오답**", Arrays.toString(result2), Arrays.toString(answer2)
//        );

        String msg3 = "ABABABABABABABAB";
        int[] answer3 = new int[]{1, 2, 27, 29, 28, 31, 30};
        int[] result3 = new Solution().solution(msg3);
        System.out.printf(
                "테스트 케이스 3: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                Arrays.equals(result3, answer3) ? "정답" : "**오답**", Arrays.toString(result3), Arrays.toString(answer3)
        );
    }

    public int[] solution(String msg) {
        Map<String, Integer> dictionary = initDictionary();
        List<Integer> result = new ArrayList<>();

        int index = 0;
        int nextIndex = 1;
        int output = -1;


        while (index < msg.length()) {
            String searchText = msg.substring(index, nextIndex);
            if (dictionary.containsKey(searchText)) {
                output = dictionary.get(searchText);
                nextIndex++;
            } else {
                result.add(output);
                dictionary.put(searchText, dictionary.size() + 1);
                index = nextIndex - 1;
                nextIndex = index + 1;
            }

            if (nextIndex > msg.length()) {
                result.add(output);
                break;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public Map<String, Integer> initDictionary() {
        Map<String, Integer> result = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            result.put(Character.toString(ch), ch - 'A' + 1);
        }
        return result;
    }
}