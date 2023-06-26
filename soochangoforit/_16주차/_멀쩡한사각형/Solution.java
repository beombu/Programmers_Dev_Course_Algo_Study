class Solution {
    public long solution(int w, int h) {
        System.out.printf("w: %d, h: %d\n", w,h);
        
        long answer = 1;
        
        // 0. 최대 공약수를 구하기 전에 큰 값을 가로로 판단.
        int rec_w = (w > h) ? w : h;
        int rec_h = (w > h) ? h : w;
        
        // 1. w와 h의 최대 공약수 구하기
        int tmp_w = rec_w;
        int tmp_h = rec_h;
        
        while (tmp_h != 0) {
            int r = tmp_w % tmp_h;
            tmp_w = tmp_h;
            tmp_h = r;
        }
        
        // 2. tmp_w가 곧 gcd 최대 공약수, gcd 만큼 패턴 반복
        int gcd = tmp_w;
        
        int pattern_w = rec_w / gcd;
        int pattern_h = rec_h / gcd;
        
        
        // 3. 패턴에 존재하는 흰색 칸 개수 구하기
        int pattern_black_block = (pattern_w - 1) * (pattern_h - 1);
        int pattern_white_block = (pattern_w * pattern_h) - pattern_black_block;
        
        
        answer = (long) w * (long) h - (gcd * pattern_white_block);
        
        
        
        return answer;
    }
}