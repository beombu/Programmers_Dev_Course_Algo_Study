/**
 * 저는 메모이제이션을 활용하지 않아 틀린 것이라고 생각했으나
 * 틀린 이유는 피보나치 함수의 return값이 int변수의 범위를 넘었기 때문이었습니다.
 * int변수 범위만 해결하는 방식으론 return(fibonacci(a - 1) + fibonacci(a - 2)) % 1234567을 넣어 해결 가능
 *
 * Time : O(n^2);
 */
public class 피보나치_수 {
    static int[] fibo;

    public int solution(int n) {
        fibo = new int[n + 1];

        return fibonacci(n);
    }

    public int fibonacci(int a) {
        //이미 메모이제이션된 피보나치라면
        if (fibo[a] > 0) {
            return fibo[a];
        }
        if(a == 0){
            return 0;
        }

        if (a == 1) {
            return 1;
        }

        return fibo[a] = (fibonacci(a - 1) + fibonacci(a - 2)) % 1234567;
    }
}
