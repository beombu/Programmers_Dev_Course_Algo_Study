import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] arr = new int[land.length][land[0].length];

        arr[0][0] = land[0][0];
        arr[0][1] = land[0][1];
        arr[0][2] = land[0][2];
        arr[0][3] = land[0][3];

        for (int i = 1; i < land.length; i++) {
            for (int k = 0; k < 4; k++) {
                int tmp = land[i][k];
                int a = 0;
                for (int nk = 0; nk < 4; nk++) {
                    if (k == nk) {
                        continue;
                    }
                    a = Math.max(arr[i - 1][nk], a);
                }
                arr[i][k] = tmp + a;
            }
        }

        int answer = 0;
        for (int i : arr[land.length - 1]) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
}
