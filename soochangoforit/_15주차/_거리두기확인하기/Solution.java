class Solution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    static int[] answer;

    // 순회하고 있는 대기실 번호, 사람의 행, 사람의 열, 탐색 깊이, 대기실 정보
    public void dfs(int num, int x, int y, int count, String[] places){
        // 탐색 깊이가 2보다 넘어가고 거리두기를 잘 준수한 경우.
        if (count > 2) return;

        // 탐색 깊이가 1~2 사이일 경우 다른 응시자가 있을 경우 거리두기 미준수로 0처리
        if (count > 0 && count <= 2 && places[x].charAt(y) == 'P'){
            //2칸 범위내에 다른 응시자가 있을 경우 거리두기 미준수로 0처리
            answer[num] = 0;
            return;
        }

        // 사람의 좌표기준으로 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //배열 범위 밖으로 초과하는지 여부 검사, 
            // 초기에 잘 지켰다는 의미로 1로 초기화를 했기에, (중요) 우리의 목적은 파티션이 없는 경우에 한해서 거리두기를 잘 지켰는지 확인하는 것이다.
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && places[nx].charAt(ny) != 'X') {
                if (visit[nx][ny]) continue; //이미 방문한 곳일 경우 생략
                visit[nx][ny] = true;
                dfs(num, nx, ny, count + 1, places); 
                visit[nx][ny] = false;
            }
        }
    }

    public int[] solution(String[][] places) {
        answer = new int[places.length];

		// (중요) 모두 거리두기를 잘 지켰다고 판단. : 잘 지켜지는 경우의 수가 더 작다. (잘 키져지지 않는 0의 경우가 더 많다.)
        // 그래서, 경우의 수가 적은 1을 기본값으로 설정 하고 잘 지켜지지 않은 경우의 수가 많은 0을 만나면 0으로 변경
        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
        }

        // 대기실의 개수만큼 반복
        for (int i = 0; i < places.length; i++) {
            // 하나의 대기실을 기점으로 방문 배열 설정
            visit = new boolean[5][5];
            // 대기실의 행을 기준으로 반복 (하나의 대기실 모두 순회)
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    // 순회를 하면서 사람을 발견한 경우
                    if (places[i][j].charAt(k) == 'P'){
                        // 사람을 방문 체크
                        visit[j][k] = true;

                        // 대기실 번호, 사람의 행, 사람의 열, 탐색 깊이, 대기실 정보
                        dfs(i, j, k, 0, places[i]);

                        // 사람 방문 체크 해제
                        visit[j][k] = false;
                    }
                }
            }
        }

        return answer;
    }
}
