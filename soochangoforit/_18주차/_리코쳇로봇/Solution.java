import java.util.*;

class Solution {
    public int solution(String[] board) {
        int ySize = board.length;
        int xSize = board[0].length();
        
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        
        int startY = 0, startX = 0, endY = 0, endX = 0;
        
        
        // 0. 시작 위치와 끝 위치를 찾는다.
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                char c = board[y].charAt(x);
                if (c == 'R') {
                    startY = y;
                    startX = x;
                } else if (c == 'G') {
                    endY = y;
                    endX = x;
                }
            }
        }
        
        
        // 1. 시작할 좌표 값을 Q에 넣는다.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX}); 
        boolean[][] visited = new boolean[ySize][xSize];
        
        // 2. 움직인 횟수
        int moveCount = 0;

        // 3. BFS 시작
        while (!queue.isEmpty()) {
            int Qsize = queue.size();
            
            
            for(int i = 0; i < Qsize; i++) {
                int[] cur = queue.poll();
                
                // 3-1. 현재 시작 좌표
                int cur_y = cur[0];
                int cur_x = cur[1];
                
                // 3-2. 미끄럼 타듯이 한번에 여러 칸 이동 
                for(int k = 0; k < 4; k++) {
                    int next_y = cur_y + dy[k];
                    int next_x = cur_x + dx[k];
                    
                    // 3-3. 미끄러듯이 이동할때 : 범위 값을 벗어나지 않고, 벽을 만나지 건까지 이동한다.
                    while (next_y >= 0 && next_y < ySize && next_x >= 0 && next_x < xSize && board[next_y].charAt(next_x) != 'D') {
                        // 3-4. 현재 방향대로 계속 이동
                        next_y += dy[k];
                        next_x += dx[k];
                        // 다만, 벽에 도달하기 까지 또는 board를 넘어가지 않으면서 거쳐왔던 좌표에 대해서는 방문 처리를 하지 않는다.
                        // 방문 처리를 해주면, 거쳐가는 와중에 End을 거치면 더 이상 End에 도달할 방법이 없다.
                        // 또한 어차피 최종적으로 이동해서 도달할 좌표는 벽을 만나기 직전 혹은 벽을 만난 좌표이다.
                        // 이러한 좌표에 대해서만 방문 처리를 통해, 최단 거리를 찾으면 된다
                    }
                    
                    // 3-5. next_y, next_x 는 벽이나, 범위를 벗어났기에 현재 방향 이동만큼 빼준다.
                    // 미끄러져서 새롭게 이동한 위치가 new_y, new_x 이다.
                    int new_y = next_y - dy[k];
                    int new_x = next_x - dx[k];
                    
                    // 3-6. 새롭게 이동한 위치가 마지막 위치이면 +1 해서 return
                    if (new_y == endY && new_x == endX) {
                        return moveCount + 1;
                    }
                    
                    // 3-7. 아직 끝점에 도달하지 못 한 경우, 지금까지 미끄러져서 도착한 마지막 new 좌표를 방문처리한다. 그리고 Q에 넣기
                    if (visited[new_y][new_x] == false) {
                        visited[new_y][new_x] = true;
                        queue.offer(new int[]{new_y, new_x});
                    }
                }
            }
            
            // 3-8. 이동할 수 있는 자식 노드들을 모두 Q에 넣었기에 moveCount++ 을 해준다.
            moveCount++;
        }
        
        // 3-9. 도달할 수 없는 경우 -1 return
        return -1;
    }
}