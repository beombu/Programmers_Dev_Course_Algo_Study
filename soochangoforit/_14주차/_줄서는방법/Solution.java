import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        
        
        k--;

        
        int[] answer = new int[n];
        
        
        for (int i = 0; i < n; i++) {
            long index = k / factorial[n - i - 1];
            answer[i] = numbers.get((int) index);
            numbers.remove((int) index);
            k -= index * factorial[n - i - 1];
        }
        
        return answer;
    }
}