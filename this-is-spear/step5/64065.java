import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public int[] solution(String s) {
		int[] memorization = new int[1_000_001];
		List<Integer> list = new ArrayList<>();
		String[] strings = s.substring(2, s.length() - 2).split("},\\{");
		List<String> collect = Arrays.stream(strings).sorted(Comparator.comparingInt(String::length))
			.collect(Collectors.toList());
		for (String one : collect) {
			String[] split = one.split(",");
			for (String str : split) {
				int i = Integer.parseInt(str);
				if (memorization[i] == 0) {
					list.add(i);
					memorization[i] = 1;
				}
			}
		}
		return list.stream().mapToInt(Integer::valueOf).toArray();
	}
}
