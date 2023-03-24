import java.util.HashSet;

/**
 * Time : O(n)
 */
public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        int[] answer = new int[2];
        int manNum = 0;
        int turnCnt = 0;
        wordSet.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (wordSet.contains(words[i]) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                if (((i + 1) % n) == 0) {
                    manNum = n;
                    turnCnt = (i + 1) / n;
                } else {
                    manNum = (i + 1) % n;
                    turnCnt = (i + 1) / n + 1;
                }
                break;
            }

            wordSet.add(words[i]);
        }
        answer[0] = manNum;
        answer[1] = turnCnt;
        return answer;
    }
}
