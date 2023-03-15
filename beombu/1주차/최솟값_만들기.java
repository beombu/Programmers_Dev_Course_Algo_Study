import java.util.Arrays;

/**
 * Time : O(n log n)
 */
public class 최솟값_만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int len = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[len - 1];
            len--;
        }
        return answer;
    }

}
