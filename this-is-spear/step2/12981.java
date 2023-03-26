import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public int[] solution(int n, String[] words) {
		Set<String> ss = new HashSet<>();
		String w = words[0];
		int count = 1;
		ss.add(w);
		char nc = w.charAt(w.length() - 1);

		for (int i = 1; i < words.length; i++) {
			String fw = words[i];
			char fc = fw.charAt(0);
			char lc = fw.charAt(fw.length() - 1);
			if (nc == fc && !ss.contains(fw)) {
				ss.add(fw);
				count++;
				nc = lc;
			} else {
				return new int[] {count % n + 1, count / n + 1};
			}
		}
		return new int[] {0, 0};
	}
}
