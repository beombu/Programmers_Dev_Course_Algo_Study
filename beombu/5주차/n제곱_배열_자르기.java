/**
 * Failure Commit : O(n^2) 풀이로 런타임 에러와 메모리 초과 둘다 발생.
 * Time : O(n)
 */
public class n제곱_배열_자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        for (int i = 0; i < answer.length; i++) {
            int row = (int) ((i + left) / n) + 1;
            int col = (int) ((i + left) % n) + 1;
            answer[i] = Math.max(row, col);
        }

        return answer;
    }
}
