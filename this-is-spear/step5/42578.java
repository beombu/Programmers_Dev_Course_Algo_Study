import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(String[][] clothes) {
		Map<String, Integer> clothesKind = new HashMap<>();

		for (String[] clothe : clothes) {
			String kind = clothe[1];
			if (clothesKind.containsKey(kind)) {
				clothesKind.put(kind, clothesKind.get(kind) + 1);
			} else {
				clothesKind.put(kind, 2);
			}
		}

		return clothesKind.values().stream().reduce((i1, i2) -> i1 * i2).get() - 1;
	}
}
