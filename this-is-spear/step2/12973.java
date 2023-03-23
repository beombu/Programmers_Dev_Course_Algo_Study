import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int solution(String s) {
		char[] chars = s.toCharArray();
		Deque<Character> deque = new ArrayDeque<>();
		for (char aChar : chars) {
			if (deque.isEmpty()) {
				deque.add(aChar);
			} else {
				if (deque.peekLast().equals(aChar)) {
					deque.pollLast();
				} else {
					deque.addLast(aChar);
				}
			}
		}
		return deque.size() == 0 ? 1 : 0;
	}
}
