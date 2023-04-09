import java.util.*;

class Solution {
	public int solution(String s) {
		String[] arr = s.split("");
		int len = arr.length;
		int start = 0;
		int count = 0;

		while (start < len) {
			if (validate(arr, len, start)) {
				count++;
			}
			start++;
		}
		return count;
	}

	public boolean validate(String[] arr, int len, int s) {
		int count = 0;
		Deque<String> dq = new ArrayDeque<>();

		while (count < len) {
			int now = (s + count) % len;
			String one = arr[now];
			if ("[({".contains(one)) {
				dq.addLast(one);
			} else if ("]".equals(one) && !"[".equals(dq.pollLast())
				|| "}".equals(one) && !"{".equals(dq.pollLast())
				|| ")".equals(one) && !"(".equals(dq.pollLast())) {
				return false;
			}
			count++;
		}
		return dq.size() == 0;
	}
}
