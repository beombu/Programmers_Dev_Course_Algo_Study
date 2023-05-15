public class _2xN_타일링 {
    public int solution(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
            }
        }

        return arr[n];
    }
}
