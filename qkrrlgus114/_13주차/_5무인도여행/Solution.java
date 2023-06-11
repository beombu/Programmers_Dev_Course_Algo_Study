import java.util.*;

class Solution {
    static int[] dr = {-1 ,0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;
    static int sum = 0;
    static int[][] map;

    public List<Integer> solution(String[] maps) {
        int H = maps.length; // 행
        int W = maps[0].length(); // 열
        map = new int[H][W];
        for(int i=0; i<H; i++){ // 맵 int로 변환
            String str = maps[i];
            for(int j=0; j<W; j++){
                if(str.charAt(j) == 'X') map[i][j] = 0;
                else{
                    map[i][j] = str.charAt(j) - '0';
                }
            }
        }

        visited = new boolean[H][W]; // 방문체크 배열
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j] != 0){ // 0이 아니면 탐색
                    BFS(i, j, H, W);
                    list.add(sum);
                    sum = 0;
                }
            }
        }
        if(list.size()==0){
            list.add(-1);
        }
        Collections.sort(list);
        System.out.println(list);

        return list;
    }

    public static void BFS(int x, int y, int H, int W){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        sum+=map[x][y];
        map[x][y] = 0;


        while(!q.isEmpty()){
            x = q.peek()[0];
            y = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int idx = x+dr[i];
                int idy = y+dc[i];
                if(idx>=0 && idx<H && idy>=0 && idy<W){ // 범위에 속하고
                    if(map[idx][idy]!=0 && !visited[idx][idy]){
                        sum += map[idx][idy];
                        map[idx][idy] = 0;
                        visited[idx][idy] = true;
                        q.add(new int[] {idx, idy});
                    }
                }
            }
        }
    }
}