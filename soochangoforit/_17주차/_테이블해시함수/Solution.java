import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        
        // 람다 표현식을 사용하여 데이터 정렬
        Arrays.sort(data, (row1, row2) -> {
            int colIdx = col - 1;
            if (row1[colIdx] == row2[colIdx]) {
                // 기본적으로 내림차순 정렬
                return Integer.compare(row2[0], row1[0]);
            } else {
                // col번째 열을 기준으로 오름차순 정렬
                return Integer.compare(row1[colIdx], row2[colIdx]);
            }
        });

        int answer = 0;

        // S_i에 대한 누적 XOR 계산
        for (int i = rowBegin - 1; i <= rowEnd - 1; i++) {
            int sum = 0;
            for (int num : data[i]) {
                sum += num % (i + 1);
            }
            answer ^= sum;
        }

        return answer;
    }
}