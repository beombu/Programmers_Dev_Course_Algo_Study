import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> groups = new ArrayList<>();

				// 0번째 index부터 상자를 열고자 한다.
        for (int i = 0; i < n; i++) {
            int now = i;
            int cnt = 0;
            int flag = 0;
            while (!visited[now]) {
                visited[now] = true;
                cnt++;
                now = cards[now] - 1;
                flag = 1;
            }
            
						// cnt가 1로 증가한 경우에 한해서만 groups에 넣을려고 한다.
            if (flag == 1) {
                groups.add(cnt);
            }
        }

				// 내림 차순 정렬
        Collections.sort(groups, Comparator.reverseOrder());
       
        return (groups.size() == 1) ? 0 : groups.get(0) * groups.get(1);
    }
}