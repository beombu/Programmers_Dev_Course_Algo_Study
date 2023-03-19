
import java.util.Arrays;

class Solution {
	public String solution(String s) {
		int[] ints = Arrays.stream(s.split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();
		return String.format("%d %d", ints[0], ints[ints.length - 1]);
	}
}
