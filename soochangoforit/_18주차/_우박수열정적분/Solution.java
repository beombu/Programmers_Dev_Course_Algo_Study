import java.util.*;

public class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> nums = new ArrayList<>();
        nums.add(k);
        int current = k;
        
        // 0. 콜라츠 추측을 통해 나온 num 값을 저장
        while(current != 1) {
            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = current * 3 + 1;
            }
            nums.add(current);
        }
        
        // 1. 각 구간의 면적을 구해서 저장.
        List<Double> areas = new ArrayList<>();
        for(int i = 0; i < nums.size() - 1; i++) {
            double area = (nums.get(i) + nums.get(i + 1)) / 2.0;
            areas.add(area);
        }
        
        // 2. 구간별로 면적의 합을 구해서 정답 리스트에 저장
        List<Double> results = new ArrayList<>();
        for(int[] range : ranges) {
            int startIdx = range[0];
            int endIdx = areas.size() + range[1];
            
            // 2.1 시작하는 idx가 end보다 큰 경우
            if (endIdx < startIdx) {
                results.add(-1.0);
            } 
            // 2.2 시작하는 idx와 end idx가 같은 경우
            else if (endIdx == startIdx) {
                results.add(0.0);
            }
            // 2.3 올바른 구간으로 면적을 구할 수 있는 경우
            else {
                double sum = 0.0;
                for(int idx = startIdx; idx < endIdx; idx++) {
                    sum += areas.get(idx);
                }
                results.add(sum);
            }
        }
        
        // 3. 정답 배열에 값 대입
        double[] answer = new double[results.size()];
        for(int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }
}