import java.util.*;

class Solution {
    private static List<int[]> answersList;
    
    public int[][] solution(int n) {
        
    
        answersList = new ArrayList<>();
        
        dfs(n,1,3,2);
        
        int[][] answer = new int[answersList.size()][2];
        for(int i = 0; i < answersList.size(); i++) {
            answer[i] = answersList.get(i);
        }
        
        return answer;
    }
    
    private void dfs (int size, int startPoint, int endPoint, int rest_of_point) {
        if(size == 1) {
            answersList.add(new int[]{startPoint, endPoint});
            return;
        }
        else {
            // 1.  1번 부터 ~ size -1 번까지의 모든 원탑을 최종 목적지(3)가 아닌, 남은 축(2)으로 전부 이동
            dfs(size - 1, startPoint, rest_of_point, endPoint);
            
            // 2. size 만큼의 숫자를 가진 가장 큰 원판을 시작 축(1)에서 도착 축(3)으로 이동
            answersList.add(new int[] {startPoint, endPoint});
            
            // 3. 1번 부터 ~ size - 1 번까지의 모든 원탑을 남은 축(2)에서 도착 축(3)으로 모두 이동
            dfs(size - 1, rest_of_point, endPoint, startPoint);
        }
    }
}