/**
 * Time : O(n^2)
 */
public class 다음_큰_숫자 {
    public int solution(int n) {
        int answer = n;
        char[] numBinaryString = Integer.toBinaryString(n).toCharArray();
        int numCount = 0;
        for (char i : numBinaryString) {
            if(i == '1'){
                numCount++;
            }
        }

        while (true) {
            answer++;
            int answerCount = 0;
            char[] answerBinaryString = Integer.toBinaryString(answer).toCharArray();
            for (char i : answerBinaryString) {
                if (i == '1') {
                    answerCount++;
                }
            }

            if (numCount == answerCount) {
                break;
            }
        }

        return answer;
    }
}
