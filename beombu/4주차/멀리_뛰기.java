/**
 * 피보나치 수와 동일한 문제
 * Time : O(n^2)
 */
public class 멀리_뛰기 {
    static int[] answer;

    public long solution(int n) {
        answer = new int[n + 1];
        dp(n);

        return answer[n];
    }

    public int dp(int n) {
        //이미 메모이제이션되엇다면
        if (answer[n] > 0) {
            return answer[n];
        }

        if (n == 1) {
            return answer[n] = 1;
        }

        if (n == 2) {
            return answer[n] = 2;
        }

        return answer[n] = (dp(n - 1) + dp(n - 2)) % 1234567;
    }
}
