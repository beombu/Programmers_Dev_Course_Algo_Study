import java.util.Arrays;

/**
 * Time : O(n log n)
 */
public class 최댓값과_최솟값 {
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
    }

    public static String solution(String s) {
        int[] numArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numArr);

        return numArr[0] + " " + numArr[numArr.length -1];
    }
}
