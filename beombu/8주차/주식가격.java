import java.util.Stack;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int nowPrice = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (nowPrice > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }

    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!indexStack.isEmpty() && prices[i] < prices[indexStack.peek()]) {
                answer[indexStack.peek()] = i - indexStack.peek();
                indexStack.pop();
            }
            indexStack.push(i);
        }

        //값을 구하지 못한 인덱스(끝까지 가격이 떨어지지 않는 주식)
        while (!indexStack.isEmpty()) {
            answer[indexStack.peek()] = prices.length - indexStack.peek() - 1;
            indexStack.pop();
        }

        return answer;
    }
}


