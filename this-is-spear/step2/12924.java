import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int solution(int n) {
		Deque<Integer> deque = new ArrayDeque<>();
		int sum = 0;
		int count = 0;

		for (int i = 1; i <= n; i++) {
			deque.add(i);
			sum += i;

			while (sum > n && !deque.isEmpty()) {
				sum -= deque.pollFirst();
			}

			if (sum == n) {
				count++;
			}
		}
		return count;
	}
}
