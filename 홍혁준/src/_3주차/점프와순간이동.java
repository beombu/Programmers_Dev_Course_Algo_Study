package src._3주차;

public class 점프와순간이동 {
    static int result = 0;

    public static int solution(int n) {
        if(isOne(n)){
            return 1;
        }else{
            go(n);
            return result;
        }
    }

    public static void go(int n){
        if(n%2==1)
            result++;

        if(n/2 == 1){
            result++;
            return;
        }

        go(n/2);
    }

    public static boolean isOne(int n){
        return n==1;
    }
}
