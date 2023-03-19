class Solution {
	public String solution(String s) {
		String[] split = s.toLowerCase().split("");
		split[0] = split[0].toUpperCase();

		for (int i = 1; i < split.length; i++) {
			if (" ".equals(split[i-1])) {
				split[i] = split[i].toUpperCase();
			}
		}
		return String.join("", split);
	}
}
