package src._4주차;

public class 멀리뛰기 {
    static long[] answer;
    public static long solution(int n) {

        answer = new long[n+1];

        recursive(n);
        return answer[n];
    }

    private static long recursive(int n) {

        if(answer[n] > 0)
            return answer[n];

        if(n == 1)
            return answer[n] = 1;
        else if(n == 2)
            return answer[n] = 2;

        return answer[n] = (recursive(n-1) + recursive(n-2)) % 1234567;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
