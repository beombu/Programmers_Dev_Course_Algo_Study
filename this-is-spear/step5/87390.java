import java.util.*;

class Solution {
	public int[] solution(int n, long left, long right) {
		int l = (int)(left / n);
		int r = (int)(right / n);
		int len = (int)(r - l);

		int[] arr = new int[(len + 1) * n];

		int count = l;

		while (count <= r) {
			for (int i = 0; i < n; i++) {
				arr[(count - l) * n + i] = i + 1 < count + 1 ? count + 1 : i + 1;
			}
			count++;
		}
		int[] aa = Arrays.copyOfRange(arr, (int)(left % n), (r - l) * n + (int)(right % n) + 1);
		return aa;
	}
}
