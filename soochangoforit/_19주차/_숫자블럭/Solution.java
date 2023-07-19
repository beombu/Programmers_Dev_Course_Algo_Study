import java.util.ArrayList;
import java.util.List;

class Solution {
    
    private int getGD(long num) {
        // 약수들의 모음
        List<Integer> list = new ArrayList<>();
        
        // 2부터 제곱근까지 나눠본다.
        for (int divisor = 2; divisor <= Math.sqrt(num); divisor++) {
            
            // 나누어 떨어지는 경우의 divisor는 num의 약수가 된다.
            if (num % divisor == 0) {
                // 약수들의 목록에 넣어준다.
                list.add(divisor);
                // 약수로 나눴을 경우 10,000,000보다 작은 경우에만 고려 (문제에서 10,000,000까지의 블록만 이용)
                // 작은 수부터 접근해서 약수로 나눈 값은 해당 위치에 제일 마지막으로 영향을 준 블록에 해당된다.
                if (num / divisor <= 10_000_000) return (int) num / divisor;
            }
            
        }

        // num이 100000014인 경우
        // 약수 :  1, 2, 3, 6, 16666669, 33333338, 50000007, 100000014 (제곱근 10,000)
        // 가능한 divisor = 2,3,6 으로 모두 나눴을 경우 몫이 10,000,000보다 크다
        if (list.size() > 0) return list.get(list.size() - 1);

        return 1;
    }

    public int[] solution(long begin, long end) {
        int[] result = new int[(int) (end - begin) + 1];
        int index = 0;

        for (long i = begin; i <= end; i++) {
            result[index++] = (i == 1) ? 0 : getGD(i);
        }

        return result;
    }
}