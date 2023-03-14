package _1주차;

import java.util.Arrays;
import java.util.StringTokenizer;

public class JadenCase {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        //세 번째 인자 true는 구분자도 토큰으로 취급하겠다는 의미
        StringTokenizer stringTokenizer = new StringTokenizer(s, " ", true);

        while (stringTokenizer.hasMoreTokens()){
            String str = stringTokenizer.nextToken();

            if(str.startsWith(" ")) {
                answer.append(str);
                continue;
            }

            answer.append((str.charAt(0)+"").toUpperCase());
            answer.append(str.substring(1).toLowerCase());
        }

        return answer.toString();
    }

    /**
     * spring 분리 -> 각 문자열 trim() 메소드로 공백 제거 -> 새로운 String 배열 생성
     * 근데 이거 쓰면 안됨 -> 왜? -> 공백 유지해야해서.
     */
    public static String[] stringToStringArray(String s){
        return Arrays.stream(s.split(" ")).map(String::trim).toArray(String[]::new);
    }
}
