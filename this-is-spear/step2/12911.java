class Solution {
	public int solution(int n) {
		// n을 2 진수로 변환해서 1의 개수를 파악한다.
		// n에서 1씩 증가시켜 1이 같은 숫자를 찾는다.
		// 어차피 1_000_000 까지 밖에 없다.

		int count = Integer.bitCount(n);
		int answer = n + 1;
		while (1_000_000 > answer) {
			if (isSame(answer, count)) {
				return answer;
			}
			answer++;
		}
		return answer;
	}

	private boolean isSame(int answer, int count) {
		return Integer.bitCount(answer) == count;
	}
}
