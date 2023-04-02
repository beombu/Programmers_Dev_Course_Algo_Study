import java.util.Arrays;

class Solution {
	public int solution(int[] people, int limit) {
		int first = 0;
		int last = people.length - 1;
		int count = 0;
		Arrays.sort(people);

		while (first <= last) {
			if (people[last] + people[first] <= limit) {
				first += 1;
				last -= 1;
			} else {
				last -= 1;
			}
			count += 1;
		}
		return count;
	}
}
