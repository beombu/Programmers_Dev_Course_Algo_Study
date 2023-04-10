package src._3주차;

public class N개의최소공배수 {
    public int solution(int[] arr) {
        int size = arr.length;
        if(size == 1) return 1;

        int gcd = toGCD(arr[0], arr[1]);
        int lcd = toLCD(arr[0], arr[1], gcd);

        for(int i=2; i<arr.length; i++){
            gcd = toGCD(lcd, arr[i]);
            lcd = toLCD(lcd, arr[i], gcd);
        }

        return lcd;
    }

    public int toGCD(int n,
                     int k){
        int result = n%k;

        if(result == 0)
            return k;
        return toGCD(k, result);
    }

    public int toLCD(int n,
                     int k,
                     int gcd){
        return n*k/gcd;
    }
}
