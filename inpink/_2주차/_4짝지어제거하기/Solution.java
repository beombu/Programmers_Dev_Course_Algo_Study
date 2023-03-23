import java.util.*;

class Solution
{
    public int solution(String s)
    {
        String[] sArray=s.split("");
		 //"붙어있는 2개" 이므로 스택을 사용하면 될 거 같았음
        List<String> stack=new ArrayList<>(); //일반배열 말고 list<>쓰자 마지막값 가져와야 하니까
        stack.add("0");
        
        for ( int i=s.length()-1; i>=0; i--){
            if (stack.get(stack.size()-1).equals(sArray[i])) stack.remove(stack.size()-1);
            else stack.add(sArray[i]);
        }
        if (stack.size()==1) return 1;
        else return 0;
    }
}