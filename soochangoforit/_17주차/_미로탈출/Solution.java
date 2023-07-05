import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};
        
        int ySize = maps.length;
        int xSize = maps[0].length();
        
        // 1. char[][] 로 초기화
        char[][] miro = new char[ySize][xSize];
        
        for(int i = 0; i < ySize; i++) {
            for(int j = 0; j < xSize; j++) {
                char word = maps[i].charAt(j);
                miro[i][j] = word;
            }
        }
        
        
        Queue<int[]> Q = new LinkedList<>();
        
        // 2. start와 end 모두 접근한 경우에만 answer을 고려하기 위해.
        int flag = 0;
        
        // 3. 전체 미로를 순회
        for(int y = 0; y < ySize; y++) {
            for(int x = 0; x < xSize; x++) {
                
                // 4. Start와 End 일 경우 BFS을 수행하며, Laber을 찾을때까지 반복한다.
                if (miro[y][x] == 'S' || miro[y][x] == 'E') {
                    
                    Q.offer(new int[] {y,x});
                    boolean[][] visited = new boolean[ySize][xSize];
                    visited[y][x] = true;
                    int moveCount = 0;
                    
                    while(!Q.isEmpty()) {
                        int Qsize = Q.size();
                        
                        for(int i = 0; i < Qsize; i++) {
                            int[] cur = Q.poll();
                            
                            int cur_y = cur[0];
                            int cur_x = cur[1];
                            
                            for(int k = 0; k < 4; k++) {
                                int next_y = cur_y + dy[k];
                                int next_x = cur_x + dx[k];
                                
                                // 5. 범위를 벗어나지 않고, 방문하지 않으며, 벽이 아닌 경우 통과 가능
                                if (next_y >= 0 && next_y < ySize && next_x >= 0 && next_x < xSize && visited[next_y][next_x] == false && miro[next_y][next_x] != 'X'){
                                        visited[next_y][next_x] = true;
                                        Q.offer(new int[] {next_y, next_x});

                                        // 6. Laber을 찾은 경우, flag를 증가시키고, moveCount를 answer에 더한다.
                                        if (miro[next_y][next_x] == 'L') {
                                            flag += 1;
                                            answer += moveCount + 1;
                                        }
                                }
                            }
                            
                        }
                        moveCount += 1;
                    }
                }
                
                
            }
        }
        
        
        // 7. Start와 End 모두 접근한 경우에만 answer을 고려한다.
        return flag == 2 ? answer : -1;
    }
}