import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[B.length - i -1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(sol.solution(A, B));
    }
}