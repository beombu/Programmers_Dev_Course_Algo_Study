/**
 * Time : O(n)
 */
public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for (int i = 3; i <= sum; i++) {
            if (sum % i == 0 && i >= sum / i && (i - 2) * (sum / i - 2) == yellow) {
                answer[0] = i;
                answer[1] = sum / i;
            }
        }

        return answer;
    }
}
