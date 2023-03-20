package src._2주차;

public class 피보나치수 {
    static int[] answer;

    public static int solution(int n) {
        answer = new int[n+1];
        answer[0] = 0;
        answer[1] = 1;
        answer[2] = 1;

        fibo(n);

        return answer[n];
    }

    private static int fibo(int n) {
        if(answer[n] > 0){
            return answer[n];
        }

        return answer[n] = (fibo(n-1)+fibo(n-2))%1234567;
    }
}
