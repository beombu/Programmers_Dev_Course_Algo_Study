import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Deque<Integer> q = new ArrayDeque<>();

        int[] arr = new int[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < numbers.length; i++) {
            while (!q.isEmpty() && numbers[q.peekLast()] < numbers[i]) {
                arr[q.pollLast()] = numbers[i];
            }
            q.add(i);
        }

        return arr;
    }
}
