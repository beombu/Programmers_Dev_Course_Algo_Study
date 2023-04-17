import java.util.*;

class Solution {
	public int solution(String str1, String str2) {
		Map<String, Integer> s1 = getMap(str1);
		Map<String, Integer> s2 = getMap(str2);

		int intersaction = getInterscation(s1, s2);
		int union = getUnion(s1, s2);
		if (union == 0 || union == intersaction) {
			return 65536;
		}

		return (int)(((double)intersaction / (union - intersaction)) * 65536);
	}

	private Map<String, Integer> getMap(String str) {
		Map<String, Integer> map = new HashMap<>();
		str = str.toLowerCase();

		for (int i = 0; i < str.length() - 1; i++) {
			if (validateChar(str.charAt(i)) && validateChar(str.charAt(i + 1))) {
				String s = String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i + 1));
				if (map.containsKey(s)) {
					map.put(s, map.get(s) + 1);
				} else {
					map.put(s, 1);
				}
			}
		}
		return map;
	}

	private boolean validateChar(char c) {
		return 'a' <= c && c <= 'z';
	}

	private int getInterscation(Map<String, Integer> s1, Map<String, Integer> s2) {
		int count = 0;
		for (String key : s1.keySet()) {
			if (s2.containsKey(key)) {
				count += Math.min(s1.get(key), s2.get(key));
			}
		}
		return count;
	}

	private int getUnion(Map<String, Integer> s1, Map<String, Integer> s2) {
		return getUnion(s1) + getUnion(s2);
	}

	private int getUnion(Map<String, Integer> s) {
		return s.values().stream().reduce((i1, i2) -> i1 + i2).orElse(0);
	}
}
