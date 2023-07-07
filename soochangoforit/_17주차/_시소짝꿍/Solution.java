import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 0. 정렬을 수행하여, 작은 무게 순으로 접근 (자신보다 작은 무게와 비교하여 answer에 값 갱신)
        Arrays.sort(weights);
        
        // 1. Map<무게, weight 배열에서 해당 무게(key)를 가지는 사람의 수>
        Map<Double, Integer> map = new HashMap<>();
        
        
        for(int weight : weights) {
            double cur_weight = weight * 1.0;
            
            // 2. 현재 몸무게 기준으로 같이 시소를 탈 수 있는 후보 무게 구하기
            double candidate1 = cur_weight * 1.0;
            double candidate2 = cur_weight * (2.0/3.0);
            double candidate3 = cur_weight * (2.0/4.0);
            double candidate4 = cur_weight * (3.0/4.0);
            
            // 3. 후보 무게들이 Map에 저장되어 있는 경우, 해당 무게를 가진 사람과 짝꿍 이루기 (answer에 추가)
            if (map.containsKey(candidate1)) answer += map.get(candidate1);
            if (map.containsKey(candidate2)) answer += map.get(candidate2);
            if (map.containsKey(candidate3)) answer += map.get(candidate3);
            if (map.containsKey(candidate4)) answer += map.get(candidate4);
            
            // 4. 현재 자기 자신 무게도 Map에 등록 시켜, 다른 누군가의 후보가 될 수 있도록 하기
            map.put(cur_weight, map.getOrDefault(cur_weight, 0) + 1);
            
        }
        
        return answer;
    }
}