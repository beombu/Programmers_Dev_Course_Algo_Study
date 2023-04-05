import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 해시 자료구조
class Solution {
	public int solution(int k, int[] tangerine) {
		int l = 0;
		int r = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : tangerine) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		List<Integer> integers = map.entrySet()
			.stream()
			.sorted((o1, o2) -> o2.getValue() - o1.getValue())
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());

		int count = 0;

		for (int i : integers) {
			if (k <= 0) {
				break;
			}
			k -= map.get(i);
			count++;
		}

		return count;
	}
}
