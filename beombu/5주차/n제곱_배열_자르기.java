import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * O(n^2) 풀이로 런타임 에러와 메모리 초과 둘다 발생.
 */
public class n제곱_배열_자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[n * n];
        //List<Integer> list = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //list.add(Math.max(i, j) + 1);
                answer[idx++] = Math.max(i, j) + 1;
            }
        }

//      list.subList((int) (left - 1), (int) right);
//      return list.stream().mapToInt(i -> i).toArray();

        answer = Arrays.copyOfRange(answer, (int) left, (int) (right + 1));
        return answer;
    }
}
