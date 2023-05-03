package src._8주차;

public class 주식가격 {

    /**
     * @param prices : 초 단위로 기록된 주식 가격이 담긴 배열
     * @return : 가격이 떨어지지 않은 기간 몇 초인지
     */
    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int currentNum = prices[i];
            int time = 0;

            for (int j = i + 1; j < prices.length; j++) {

                time++;
                if (prices[j] < currentNum) break;
            }
            answer[i] = time;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] p = new int[]{1, 2, 3, 2, 3};
        int[] a = solution(p);
    }
}
