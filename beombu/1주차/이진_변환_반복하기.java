/**
 * Time : O(n^2)
 * Integer.toBinaryString : Int타입을 String 타입의 이진수로 변환하는 메소드
 */
public class 이진_변환_반복하기 {
     public int[] solution(String s) {
        int zeroCnt = 0;
        int calCnt = 0;

        while(!s.equals("1")){
            int len = s.length();
            for (char a : s.toCharArray()) {
                if (a == '0') {
                    zeroCnt++;
                    len--;
                }
            }

            s = Integer.toBinaryString(len);
            calCnt++;
        }

        return new int[]{calCnt, zeroCnt};
    }
}
