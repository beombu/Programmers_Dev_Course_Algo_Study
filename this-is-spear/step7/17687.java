class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < t * m; i++) {
            s.append(Integer.toString(i, n).toUpperCase());
        }

        String a = s.toString();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int k = m * i + p - 1;
            answer.append(a.charAt(k));
        }

        return answer.toString();
    }
}
