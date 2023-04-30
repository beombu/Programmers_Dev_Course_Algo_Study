import java.util.PriorityQueue;

/**
 * Time : O(n log n)
 */
public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int shakeNum = 0;

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (pq.peek() < K && pq.size() >= 2) {
            int lowScovilleFood1 = pq.poll();
            int lowScovilleFood2 = pq.poll();

            //제한 사항 : 모든 음식의 스코필 지수를 K이상으로 만들수 없는 경우 -1
            if (lowScovilleFood1 == 0 && lowScovilleFood2 == 0) {
                return -1;
            }

            pq.add(lowScovilleFood1 + (lowScovilleFood2 * 2));
            shakeNum++;
        }

        if (pq.size() == 1 && pq.peek() < K) {
            return -1;
        }

        return shakeNum;
    }
}
