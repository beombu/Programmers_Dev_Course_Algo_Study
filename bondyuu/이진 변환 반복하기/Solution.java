import java.util.Arrays;

class Solution {
    int[] answer = new int[2];
    public int[] solution(String s) {

        action(0,0,s);
        return this.answer;
    }

    private void action(int seq, int zeroNum, String str) {
        String zeroRemoved = str.replace("0","");

        int removedNum = str.length() - zeroRemoved.length();

        str = Integer.toBinaryString(zeroRemoved.length());

        if (str.equals("1")) {
            this.answer[0] = seq+1;
            this.answer[1] = zeroNum+removedNum;
            return;
        }
        action(seq+1, zeroNum+removedNum, str);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution("110010101001")));
    }
}