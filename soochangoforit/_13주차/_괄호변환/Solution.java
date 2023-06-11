
import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        answer = algorithm(p);
        return answer;
    }
    
    public String algorithm(String input) {
        // 1. input을 2개의 문자열로 분리해야 한다. 앞부분은 균형 잡힌 문자열이여야 한다. 
        if (input.isEmpty() || isTotallyRight(input)) {
            return input;
        }
        
        int splitIndex = getSplitIndex(input);
        
        // splitIndex 지점부터 좌측은 u, 우측은 v
        String u = input.substring(0, splitIndex);
        String v = input.substring(splitIndex);
        
        // 2. u 문자열이 올바른 괄호 문자열인 경우
        if (isTotallyRight(u)){
            return u + algorithm(v);
        }
        else {
            // 2. u 문자열이 올바른 괄호 문자열이 아니라고 판단하고 진행
            // 2-1. v에 "(" 삽입
            StringBuffer vBuf = new StringBuffer();
            vBuf.append("(");
            vBuf.append(algorithm(v));
            vBuf.append(")");
            // 2-2. u의 첫번째랑 마지막을 제외한 부분에 대해 () 뒤집기
            u = u.substring(1, u.length() - 1);
            for (char ch : u.toCharArray()) {
                if (ch == '(') {
                    vBuf.append(')');
                } else {
                    vBuf.append('(');
                }
            }
            return vBuf.toString();
        }
        
        
    }
    
    private int getSplitIndex(String input) {
        int left = 0;
        int right = 0;
        int needToBeSplit = 0;
        for(int i = 0; i < input.length(); i++) {
            
            if(input.charAt(i) == ')') {
                left++;
            }
            else{
                right++;
            }
            
            if (left != 0 && right != 0 && left == right) {
                needToBeSplit = i;
                break;
            }
        }
        return needToBeSplit + 1;
    }
    
    // 올바른 괄호 문자열인지 확인한다. u에 들어오는 문자열은 (, ) 의 개수는 동일하다.
    private boolean isTotallyRight(String u) {
        int balance = 0;
        
        for(char c : u.toCharArray()) {
            if (c == '(') {
                balance++;
            }
            else {
                balance--;
            }
            
            if (balance < 0) {
                return false;
            }
        }
        
        return balance == 0;
    }
    
    
}