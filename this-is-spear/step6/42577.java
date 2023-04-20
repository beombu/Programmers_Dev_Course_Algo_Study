import java.util.*;

// 트라이 자료 구조
class Solution {
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for (String phone : phone_book) {
			if (!Trie.addPhoneNumber(phone))
				return false;
		}
		return true;
	}

	private static class Trie {
		private static final Trie ROOT = new Trie('R', false);
		private final Map<Character, Trie> nxt;
		private final char cur;
		private boolean flag;

		public Trie(char cur, boolean flag) {
			this.cur = cur;
			this.flag = flag;
			this.nxt = new HashMap<>();
		}

		public static boolean addPhoneNumber(String num) {
			Trie cur = ROOT;
			for (int i = 0; i < num.length(); i++) {
				if (cur.flag) {
					return false;
				}
				cur = cur.nxt.computeIfAbsent(num.charAt(i), c -> new Trie(c, false));
			}
			cur.flag = true;
			return true;
		}
	}
}
