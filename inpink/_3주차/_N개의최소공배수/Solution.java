class Solution {
    public int solution(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans =  (ans * arr[i]) / gcd(ans, arr[i]);
        }
        return ans;
    }

    private static int gcd(int a, int b) { //유클리드 호제법
        int tmp;
        while (true) {
            if (b==0) break;
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
