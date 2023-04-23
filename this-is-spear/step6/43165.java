class Solution {
	public int solution(int[] numbers, int target) {
		return recursive(0, target, 0, numbers);
	}

	private int recursive(int num, int t, int i, int[] nums) {
		if (nums.length == i) {
			if (num == t) {
				return 1;
			}
			return 0;
		}

		return recursive(num + nums[i], t, i + 1, nums)
			+ recursive(num - nums[i], t, i + 1, nums);
	}
}
