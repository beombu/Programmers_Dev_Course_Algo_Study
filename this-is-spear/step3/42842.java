class Solution {
	public int[] solution(int brown, int yellow) {
		for (int x = 1; x < (brown + 4) / 2; x++) {
			int y = (brown + 4) / 2 - x;
			if ((x - 2) * (y - 2) == yellow) {
				if (x > y) {
					return new int[] {x, y};
				}
				return new int[] {y, x};
			}
		}
		int[] answer = {-1, -1};
		return answer;
	}
}
