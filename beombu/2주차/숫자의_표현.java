/**
 * Time : O(n)
 */
public class 숫자의_표현 {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int end = 1;
        int sum = 0;

        while (start <= n || end <= n) {
            if (sum == n) {
                answer++;
                sum -= start++;
            } else if (sum > n) {
                sum -= start++;
            } else {
                sum += end++;
            }
        }

        return answer;
    }
}
