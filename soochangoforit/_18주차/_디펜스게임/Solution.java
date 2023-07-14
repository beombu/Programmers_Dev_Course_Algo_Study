import java.util.*;

class Solution {
    public int solution(int initialSoldiers, int invincibilityTickets, int[] enemyCountsPerRound) {
        
        // 우선 순위 큐 생성. 큰 숫자부터 나오도록 설정
        PriorityQueue<Integer> enemyCounts = new PriorityQueue<>(Collections.reverseOrder());
        
        int completedRounds = 0;
        
        for (int enemyCount : enemyCountsPerRound) {
            // 현재 라운드의 적 수를 우선 순위 큐에 추가
            enemyCounts.add(enemyCount);
            
            // 만약 적의 수가 병사의 수보다 많다면...
            if (enemyCount > initialSoldiers) {
                // 무적 티켓이 없다면, 지금까지 완료한 라운드 수를 반환
                if (invincibilityTickets == 0) {
                    break;
                }
                
                // 무적 티켓을 사용한다. 이번 라운드의 병사 손실을 "되돌린" 후, 가장 큰 과거 라운드의 적의 수를 감소시킨다.
                initialSoldiers -= enemyCount;
                int largestPastRoundEnemyCount = enemyCounts.poll();
                initialSoldiers += largestPastRoundEnemyCount;
                
                // 무적 티켓의 수를 감소시킨다.
                invincibilityTickets--;
            }
            // 만약 적의 수가 병사의 수보다 적거나 같다면, 병사를 사용한다.
            else {
                initialSoldiers -= enemyCount;
            }
            
            // 완료한 라운드의 수를 증가시킨다.
            completedRounds++;
        }
        
        // 완료한 라운드의 수를 반환한다.
        return completedRounds;
    }
}
