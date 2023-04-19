import java.util.*;

class Solution {
	private static final int TEN = 10;

	public int solution(String[] want, int[] number, String[] discount) {
		Map<String, Integer> map = initializeMap(want);
		int[] checked = initializeArray(number, discount, map);
		int answer = 0;

		answer += check(number, checked);

		for (int i = TEN; i < discount.length; i++) {
			change(discount, map, checked, i - TEN, -1);
			change(discount, map, checked, i, 1);
			answer += check(number, checked);
		}
		return answer;
	}

	private int[] initializeArray(int[] number, String[] discount, Map<String, Integer> map) {
		int[] checked = new int[number.length];
		for (int i = 0; i < TEN; i++) {
			change(discount, map, checked, i, 1);
		}
		return checked;
	}

	private Map<String, Integer> initializeMap(String[] want) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			map.put(want[i], i);
		}
		return map;
	}

	private void change(String[] discount, Map<String, Integer> map, int[] checked, int i, int num) {
		if (map.containsKey(discount[i])) {
			checked[map.get(discount[i])] += num;
		}
	}

	private int check(int[] number, int[] checked) {
		for (int i = 0; i < number.length; i++) {
			if (number[i] != checked[i])
				return 0;
		}
		return 1;
	}
}
