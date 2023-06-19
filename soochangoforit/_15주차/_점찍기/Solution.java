import java.util.*;

class Solution {

    public long solution(int k, int d) {
        long answer = 0;


        for(int x = 0; x*k <= d; x++) {
            // 최대 d 거리 값 안에 들어오는 y의 최대값
            long remaining = (long) d*d - (long) k*x*k*x;
            // 최대 d 거리 값 안에 들어오는 y의 최대 갯수 (0을 포함 X)
            int max_y = (int) (Math.sqrt(remaining) / k);

            // 0을 포함하므로 +1
            answer += max_y + 1;
        }


        return answer;
    }
}