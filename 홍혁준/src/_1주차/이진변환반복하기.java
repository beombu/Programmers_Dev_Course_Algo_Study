package src._1주차;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int zeroCount = 0;
        int changeCount = 0;

        while (!s.equals("1")){
            int length = s.length();

            for(char c : s.toCharArray()){
                if(c == '0'){
                    zeroCount++;
                    length--;
                }
            }

            s = Integer.toBinaryString(length);
            changeCount++;
        }

        return new int[]{changeCount, zeroCount};
    }
}
