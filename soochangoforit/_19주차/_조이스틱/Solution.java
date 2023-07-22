import java.util.Arrays;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로 쭉 간 횟수
        
        for(int i = 0; i < name.length(); i++) {
            
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); //상,하 알파벳 맞추기
            
            // 현재 위치에서 오른쪽 문자가 A 라면, 오른쪽으로 이동하면서 만나는 최소의 'A' 말고 다른 문자열을 찾는다.
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;

                // 정방향으로 이동하면서 A가 아닌 최소의 다른 문자열의 idx가 endA에 담긴다.
                while(endA < name.length() && name.charAt(endA) == 'A') {
                    endA++;
                }

                // 원래 i까지 정방향으로 이동했다가, 역방향으로 endA idx까지 움직이는 경우
                // 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, (i * 2) + (name.length() - endA));
                
                // endA idx까지 역방향으로 이동했다가, 정방향으로 i까지 움직이는 경우
                // 왼쪽으로 갔다 다시 오른쪽으로 꺾기
                move = Math.min(move, i + ((name.length() - endA) * 2) );
            }
            
            // move 에는 {i까지 정방향으로 이동 후 endA까지 역방향 이동} || {역방향으로 endA까지 이동 후 i까지 정방향 이동} 
            // 혹은 정방향으로 길이만큼 이동하는 최소한의 횟수가 담겨있다.
            // i가 (0 idx) ~ (length - 1 idx)까지 이동하면서 각각의 idx 별로 이동할 수 있는 최소한의 이동 횟수(move)을 지속적 업데이트 해준다 
            
            
        }
        
        // 최종적으로는 {각 문자별로 'A'부터 상하로 조작한 모든 횟수} + {이동할 수 있는 최소한의 좌우 움직임}
        return answer + move;
    }
}