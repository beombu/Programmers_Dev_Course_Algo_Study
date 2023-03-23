import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
		//HashSet쓰면 되는 문제
        HashSet<String> set = new HashSet<String>();
        
        //0번값은 무조건 넣으면 됨
        set.add(words[0]);
        
        for (int i=1; i<words.length;i++) { //1번부터 n-1까지 비교해주면 됨.
        	if (set.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0) )
        	{//실패 : 이미 있는 값을 불렀을 경우 or 앞뒤가 다름
        		answer[0]=i%n+1;
        		answer[1]=i/n+1;
                break;
        	}
        	else set.add(words[i]); //성공
        }
        return answer;
    }
}