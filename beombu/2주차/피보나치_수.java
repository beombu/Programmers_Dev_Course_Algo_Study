public class 피보나치_수 {
    public int solution(int n) {
        return fibonacci(n)%1234567;
    }

    public int fibonacci(int a) {
        if(a == 0){
            return 0;
        }

        if (a == 1) {
            return 1;
        }

        return fibonacci(a - 1) + fibonacci(a - 2);
    }
}
