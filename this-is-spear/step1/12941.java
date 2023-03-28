import java.util.Arrays;

class Solution {
	public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);

		int length = A.length;
		for (int i = 0; i < length; i++) {
			answer += A[i] * B[length - i - 1];
		}

		return answer;
	}
}