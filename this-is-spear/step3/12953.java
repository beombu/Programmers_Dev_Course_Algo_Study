class Solution {
	public int solution(int[] arr) {
		int c = 0;
		int answer = 1;
		while (c < arr.length) {
			answer = lcm(answer, arr[c]);
			c++;
		}
		return answer;
	}

	private int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	private int lcm(int x, int y) {
		return (x * y) / gcd(x, y);
	}
}
