class Solution {
    public int[] solution(int[] prices) {
        int l = prices.length;
        int[] answer = new int[l];
        for (int i = 0; i < l; i++) {
            int one = prices[i];
            for (int k = i + 1; k < l; k++) {
                if (one > prices[k] || k == l - 1) {
                    answer[i] = k - i;
                    break;
                }
            }
        }
        return answer;
    }
}
