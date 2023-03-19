class Solution {
	boolean solution(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if ('(' == s.charAt(i)) {
				count += 1;
			} else {
				if (count == 0) {
					return false;
				}
				count -= 1;
			}
		}
		return count == 0;
	}
}
