package _4주차.괄호회전하기.java;

import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        String s1 = "[](){}";
        assert new Solution().solution(s1) == 3 : "실패";

        String s2 = "}]()[{";
        assert new Solution().solution(s2) == 2 : "실패";

        String s3 = "[)(]";
        assert new Solution().solution(s3) == 0 : "실패";

        String s4 = "}}}";
        assert new Solution().solution(s4) == 0 : "실패";
    }

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (isRight(s)) answer++;
        }
        return answer;
    }

    private boolean isRight(String str) {
        String regex = "(\\(\\)|(\\{\\})|(\\[\\]))";
        Pattern pattern = Pattern.compile(regex);
        while (pattern.matcher(str).find()) {
            str = str.replaceAll(regex, "");
        }
        return str.length() == 0;
    }
}
