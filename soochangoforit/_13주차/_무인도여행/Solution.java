package soochangoforit._13주차._무인도여행;

import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;
    char[][] map;
    List<Integer> islands;

    public void bfs(int x, int y, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int islandSum = map[x][y] - '0';

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] != 'X') {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    islandSum += map[nx][ny] - '0';
                }
            }
        }
        islands.add(islandSum);
    }

    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        islands = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 'X' && !visited[i][j]) {
                    bfs(i, j, n, m);
                }
            }
        }

        if(islands.size() == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[islands.size()];
        for(int i = 0; i < islands.size(); i++) {
            answer[i] = islands.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}