import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    public static String[] words = {"A", "E", "I", "O", "U"};
    private static List<String> list = new ArrayList<>();

    public int solution(String word) {
        dfs(0, "");

        int answer = list.indexOf(word);
        return answer;
    }

    private void dfs(int dep, String str) {
        if (dep > words.length) {
            return;
        }

        list.add(str);
        for (int i = 0; i < words.length; i++) {
            dfs(dep + 1, str + words[i]);
        }
    }

    public static void main(String[] args) {
        int result = new 모음사전().solution("AAAE");

        System.out.println(result);
    }
}
