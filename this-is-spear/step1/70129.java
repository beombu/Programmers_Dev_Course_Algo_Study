class Solution {
	private static final String ONE = "1";
	private static final String TOW = "0";

	public int[] solution(String s) {
		int[] answer = new int[2];

		String now = s;
		while (!ONE.equals(now)) {
			if (TOW.equals(now)) {
				break;
			}
			// 0을 다 뺸다.
			int count = 0;
			int length = now.length();
			for (int i = 0; i < length; i++) {
				if ('1' == now.charAt(i)) {
					count++;
				}
			}

			answer[1] += length - count;
			answer[0] += 1;
			// now 를 이진변환한다.
			now = Integer.toBinaryString(count);
		}

		return answer;
	}
}
