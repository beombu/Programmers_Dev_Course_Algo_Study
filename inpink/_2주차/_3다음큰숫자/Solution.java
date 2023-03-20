class Solution {
    public int solution(int n) {
        
        int answer = 0;
        String s = Integer.toBinaryString(n);
        int count = 0;
        String tmp;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1') count++;
        }
        for(int i=n+1; i<1000000; i++){
            tmp = Integer.toBinaryString(i);
            int tmp_cnt = 0;
            for(int j = 0; j<tmp.length(); j++){
                if(tmp.charAt(j) == '1') tmp_cnt++;
            }
            if(tmp_cnt == count) {
                answer = i;
                break;
            }
        } return answer;
        
    }
    
}