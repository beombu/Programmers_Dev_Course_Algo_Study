import java.util.*;

class Solution {
	public int solution(int[] elements) {
		int len = elements.length;
		Set<Integer> sums = new HashSet<>();
		for (int i = 1; i <= len - 1; i++) {
			for (int j = 1; j < len * 2 - 1; j++) {
				int sum = 0;
				for (int k = 0; k < i; k++) {
					int index = ((j - 1) + k) % len;
					sum += elements[index];
				}
				sums.add(sum);
			}
		}

		sums.add(Arrays.stream(elements).sum());

		return sums.size();
	}
}
