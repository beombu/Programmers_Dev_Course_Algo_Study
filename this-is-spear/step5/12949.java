class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		// answer 배열 안의 배열 개수는 arr1의 열에 의해 배열의 크기는 arr2의 행에 의해 결정된다.
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; ++i) {
			for (int j = 0; j < arr2[0].length; ++j) {
				for (int k = 0; k < arr1[0].length; ++k) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return answer;
	}
}
