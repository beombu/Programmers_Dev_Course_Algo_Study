import java.util.*;

class Solution {
    String[] SELECTED = new String[5];

    public int solution(String word) {
        PriorityQueue<String> q = new PriorityQueue<>();
        recursion(0, word, q);
        return findAnswer(word, q);
    }

    private int findAnswer(String word, PriorityQueue<String> q) {
        int answer = 0;
        while (!q.isEmpty()) {
            answer++;
            if (q.poll().equals(word)) {
                return answer;
            }
        }
        return 0;
    }

    private void recursion(int i, String word, PriorityQueue<String> q) {
        if (i != 5) {
            for (String s : new String[] { "A", "E", "I", "O", "U" }) {
                SELECTED[i] = s;
                q.add(getString());
                recursion(i + 1, word, q);
                SELECTED[i] = null;
            }
        }
    }

    private String getString() {
        StringBuilder sb = new StringBuilder();
        for (String s : SELECTED) {
            if (s != null) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
