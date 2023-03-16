import java.lang.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count=0;
        int zero=0;
        int zeroCount=0;
        
        //15만회 -> 2^18이므로 18개로 줄어듬 -> ... 시간복잡도 O(N) OK
        while (true){
            if (s.equals("1")) break;
            count++;
            String[] l=s.split("");
            zero=0;
            for (int i=0; i<l.length; i++) {
                if(l[i].equals("0")) {
                    zero++;
                }
            }
            //System.out.println(sb.toString()+zero);
            //10진수 to 2진수
            s = Integer.toBinaryString(s.length()-zero);
            zeroCount+=zero;
            
        }

        answer[0]=count;
        answer[1]=zeroCount;
        
        return answer;
    }
}