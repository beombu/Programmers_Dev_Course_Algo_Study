import java.util.StringTokenizer;

/**
 * Time : O(n^2)
 */
public class JadenCase_문자열_만들기 {
    public static String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String str = st.nextToken();

            if(str.equals(" ")){//공백 체크
                sb.append(str);
                continue;
            }

            sb.append(Character.toString(str.charAt(0)).toUpperCase());
            sb.append(str.substring(1).toLowerCase());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("aaa aa     aaa  "));
    }
}
