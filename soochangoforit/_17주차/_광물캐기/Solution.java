import java.util.*;

class Solution {
    class Fatigue {
        int diamond;
        int iron;
        int stone;

        Fatigue(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        // key : 광물, value : [다이아 곡갱이, 철 곡갱이, 돌 곡갱이] => 각 곡갱이로 캘 경우 피로도
        Map<String, int[]> fatigueMap = new HashMap<>();
        fatigueMap.put("diamond", new int[]{1, 5, 25});
        fatigueMap.put("iron", new int[]{1, 1, 5});
        fatigueMap.put("stone", new int[]{1, 1, 1});
        
        // 테스트 케이스 8번
        int totalPicks = Arrays.stream(picks).sum();

        List<Fatigue> fatigueCounts = new ArrayList<>();
        for (int i = 0; i < minerals.length; i += 5) {
            
            // 테스트 케이스 8번
            if(totalPicks == 0) break;
            
            // 광물 5개를 캐는데, {다이아로 모두 할 경우 피로도, 철로 모두 피로도, 돌로 모두 피로도};
            int[] fatigueCount = new int[]{0, 0, 0};
            
            // 광물을 캘 최대 index (5개를 그룹으로 생각한다)
            int limit = Math.min(i + 5, minerals.length);
            for (int j = i; j < limit; j++) {
                // 해당 광물을 캐는데 곡갱이 별로 생기는 피로도를 temp에 넣는다.
                String target_mineral = minerals[j];
                int[] fatigue_each_picks = fatigueMap.get(target_mineral);
                fatigueCount[0] += fatigue_each_picks[0]; // 해당 광물을 "다이아"로 5개 캐는 경우 쌓이는 피로도
                fatigueCount[1] += fatigue_each_picks[1]; // 해당 광물을 "철"로 5개 캐는 경우 쌓이는 피로도
                fatigueCount[2] += fatigue_each_picks[2]; // 해당 광물을 "돌"로 5개 캐는 경우 쌓이는 피로도
            }
            fatigueCounts.add(new Fatigue(fatigueCount[0], fatigueCount[1], fatigueCount[2]));
            // 테스트 케이스 8번
            totalPicks--;
        }
        
        
        // fatigueCounts 에는 순서대로 5개 광물을 캐는데, 쌓이는 피로도 의미
        // 10개의 광물이 있다면 fatigueCounts 에는 2개의 size가 존재한다.
        

        fatigueCounts.sort(Comparator.comparingInt(a -> -a.stone));
        int totalFatigue = 0;

        
        for (Fatigue fatigue : fatigueCounts) {
            
            // 다이아 곡갱이
            if (picks[0] > 0) {
                totalFatigue += fatigue.diamond;
                picks[0]--;
            } 
            
            // 철 곡갱이
            else if (picks[1] > 0) {
                totalFatigue += fatigue.iron;
                picks[1]--;
            } 
            
            // 돌 곡갱이
            else if (picks[2] > 0) {
                totalFatigue += fatigue.stone;
                picks[2]--;
            } else {
                break;
            }
        }

        return totalFatigue;
    }
}