package src._7주차;

public class N진수게임 {

    /**
     * - 숫자를 0부터 시작해 차례대로 말함.
     * - 10이상의 숫자부터 한 자리씩 끊어서 말함
     *
     * @param n : 진법
     * @param t : 미리 구할 숫자 개수
     * @param m : 게임에 참가하는 인원
     * @param p : 튜브의 순서
     * @return : 튜브가 말해야 하는 숫자들
     */
    public static String solution(int n,
                                  int t,
                                  int m,
                                  int p) {

        StringBuilder answer = new StringBuilder();
        StringBuilder numberBase = new StringBuilder();

        int maxSize = t*m;
        int index = 0;

        while (numberBase.toString().length() < maxSize){
            numberBase.append(toNumberBase(n, index++));
        }

        String totalNumber = numberBase.toString();
        for(int i=0; i<t; i++){
            answer.append(totalNumber.charAt(i*m+p-1));
        }

        return answer.toString();
    }

    public static String toNumberBase(int n,
                                      int number){

        if(number == 0)
            return "0";

        StringBuilder stringBuilder = new StringBuilder();

        while(number > 0){
            int remain = number % n;
            number /= n;

            if(remain < 10){
                stringBuilder.append(remain);
            }else{
                stringBuilder.append((char)('A' + remain - 10));
            }
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }
}
