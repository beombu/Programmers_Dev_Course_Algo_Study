import java.util.Stack;

class Solution {
    private static Character OPEN_BRACKET = '(';
    boolean solution(String s) {

        Stack<Character> st = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c.equals(OPEN_BRACKET)) {
                st.push(c);
                continue;
            }

            if (st.isEmpty()) {
                return false;
            }

            st.pop();
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol  = new Solution();

        System.out.println(sol.solution(")()("));
    }
}