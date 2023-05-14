package _9주차._3차파일명정렬.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        String[] files1 = new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] answer1 = new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
        String[] result1 = new Solution().solution(files1);
        PRINT_RESULT(1, result1, answer1);

        String[] files2 = new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] answer2 = new String[]{"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"};
        String[] result2 = new Solution().solution(files2);
        PRINT_RESULT(2, result2, answer2);
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

    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for (String file : files) {
            list.add(new File(file));
        }
        Collections.sort(list);
        return list.stream().map(File::getFileName).toArray(String[]::new);
    }

    class File implements Comparable<File> {
        private String head;
        private String number;
        private String fileName;

        File(String fileName) {
            Matcher headMatcher = Pattern.compile("[a-zA-Z\\-\\.\\s]+").matcher(fileName);
            if (headMatcher.find()) {
                this.head = headMatcher.group().toLowerCase();
            }

            Matcher numberMatcher = Pattern.compile("[0-9]+").matcher(fileName);
            if (numberMatcher.find()) {
                this.number = numberMatcher.group();
            }

            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }

        @Override
        public int compareTo(File o) {
            if (!this.head.equals(o.head)) {
                return this.head.compareTo(o.head);
            }
            return Integer.parseInt(this.number) - Integer.parseInt(o.number);
        }
    }
}