import java.util.*;
class Solution {
    static int[][] map;

    public List<Integer> solution(int rows, int columns, int[][] queries){
        map = new int[rows+2][columns+2];
        int[] result = new int[map.length];
        List<Integer> list = new ArrayList<>();

        int count = 1;
        for(int i=1; i<rows+1; i++){
            for(int j=1; j<columns+1; j++){
                map[i][j] = count++;
            }
        }

        for(int i=0; i<queries.length; i++){
            list.add(rotate(queries[i]));
        }
        return list;
    }

    public int rotate(int[] arr){
        int y1 = arr[0];
        int x1 = arr[1];
        int y2 = arr[2];
        int x2 = arr[3];
        int min = Integer.MAX_VALUE;
        int temp = map[y1][x2];
        // 맨 위
        for(int i=x2; i>x1; i--){
            map[y1][i] = map[y1][i-1];
            min = Math.min(min, map[y1][i]);
        }
        // 맨 왼쪽
        for(int i=y1; i<y2; i++){
            map[i][x1] = map[i+1][x1];
            min = Math.min(min, map[i][x1]);
        }
        // 맨 아래
        for(int i=x1; i<x2; i++){
            map[y2][i] = map[y2][i+1];
            min = Math.min(min, map[y2][i]);
        }
        // 맨 오른쪽
        for(int i=y2; i>y1; i--){
            map[i][x2] = map[i-1][x2];
            min = Math.min(min, map[i][x2]);
        }
        map[y1+1][x2] = temp;
        min = Math.min(min, temp);
        return min;
    }
}