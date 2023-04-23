import java.util.ArrayList;
import java.util.Stack;

public class 타겟_넘버 {

    public int solution(int[] numbers, int target) {
        int answer = 0;
        int stackNum = 0;
        int nextNum = 0;

        ArrayList<Integer> list;
        Stack<Integer> stack = new Stack<>();

        stack.push(numbers[0]);
        stack.push(numbers[0] * -1);

        for (int i = 1; i < numbers.length; i++) {
            nextNum = numbers[i];
            list = new ArrayList<>();

            while (!stack.isEmpty()) {
                stackNum = stack.pop();

                list.add(stackNum + nextNum);
                list.add(stackNum + (nextNum * -1));
            }

            for (int j = 0; j < list.size(); j++) {
                stack.push(list.get(j));
            }
        }

        for (Integer sum : stack) {
            if (sum == target) {
                answer++;
            }
        }

        return answer;
    }
}
