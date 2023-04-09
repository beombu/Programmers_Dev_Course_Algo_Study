/**
 * Time : O(n)
 * 테스트 케이스 5000을 풀어 답을 도출
 */
public class 점프와_순간_이동 {
    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 1) {
                n--;
                ans++;
            } else {
                n /= 2;
            }
        }

        return ans;
    }
}
