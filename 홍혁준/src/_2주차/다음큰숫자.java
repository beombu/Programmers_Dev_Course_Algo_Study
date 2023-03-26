package _2주차;

public class 다음큰숫자 {
    public int solution(int n) {
        int answer = 0;

        int count = Integer.bitCount(n);

        for(int i=n+1; i<=1000000; i++){
            int tempCount = Integer.bitCount(i);

            if(count == tempCount){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
