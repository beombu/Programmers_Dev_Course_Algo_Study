class Solution {
	int[] SELECTED, USED;
	int[][] DUNGEONS;
	int LEN;
	int ANSWER = 0;
	int LIMIT;

	public int solution(int k, int[][] dungeons) {
		SELECTED = new int[dungeons.length + 1];
		USED = new int[dungeons.length + 1];
		DUNGEONS = dungeons;
		LEN = dungeons.length;
		LIMIT = k;

		recursion(1);
		return ANSWER;
	}

	public void recursion(int t) {
		if (t == LEN + 1) {
			ANSWER = Math.max(ANSWER, solve(SELECTED, LIMIT));
		} else {
			for (int i = 1; i <= LEN; i++) {
				if (USED[i] == 1) {
					continue;
				}
				SELECTED[t] = i;
				USED[i] = 1;
				recursion(t + 1);
				SELECTED[t] = 0;
				USED[i] = 0;
			}
		}
	}

	public int solve(int[] selected, int k) {
		int a = 0;

		for (int i = 1; i < selected.length; i++) {
			int[] dungeon = DUNGEONS[selected[i] - 1];

			if (k < dungeon[0]) {
				break;
			}
			k -= dungeon[1];
			a++;
		}

		return a;
	}
}
