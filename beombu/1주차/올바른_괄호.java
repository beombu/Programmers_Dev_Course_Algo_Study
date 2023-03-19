import java.util.Stack;

/**
 * Time : O(n)
 */
public class 올바른_괄호 {
    static Stack<Character> stack = new Stack<>();

    boolean solution(String s) {
        boolean answer = true;
        char[] chArr = s.toCharArray();

        if(chArr[0] == ')'){
            return false;
        }

        for (char ch : chArr) {
            if (ch == '(') {
                stack.add(ch);
            } else if (ch == ')' && stack.isEmpty()) {
                return false;
            }else{
                stack.pop();
            }
        }

        if(stack.isEmpty()){
            answer = true;
        }else{
            answer = false;
        }

        return answer;
    }
}
