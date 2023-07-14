class Solution {
   
 public int solution(int n) {
        int result = 0;
        int[] cols = new int[n];
        result = backTrack(0, cols, n);

        return result;
    }

    public int backTrack(int level, int[] cols, int n) {
        int sum = 0;
        if (level == n) {
            return 1;
        } else {
            for (int i = 0; i < n; i++) {
                cols[level] = i;
                if (possible(level, cols)) {
                    sum += backTrack(level + 1, cols, n);
                }
            }
        }
        return sum;
    }


    public boolean possible(int level, int[] cols) {
        for (int i = 0; i < level; i++) {
            if (cols[i] == cols[level] || Math.abs(level - i) == Math.abs(cols[i] - cols[level])) {
                return false;
            }
        }
        return true;
    }

}
