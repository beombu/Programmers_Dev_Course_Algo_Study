import java.util.*;

class Solution {
        
    public int solution(int N, int[][] road, int K) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
 
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        
        
        int[] minTime = new int[N + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int village = current[0];
            int time = current[1];

            if (time > minTime[village]) {
                continue;
            }

            for (int[] neighbor : graph.get(village)) {
                int nextVillage = neighbor[0];
                int edgeWeight = neighbor[1];

                if (time + edgeWeight < minTime[nextVillage]) {
                    minTime[nextVillage] = time + edgeWeight;
                    pq.offer(new int[]{nextVillage, time + edgeWeight});
                }
            }
        }
      
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (minTime[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

}