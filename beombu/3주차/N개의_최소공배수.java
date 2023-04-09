/**
 * Time : O(n^2)
 * 유클리드 호제법 : 최대공약수를 구하는 알고리즘(Greatest Common Divisor)
 * (큰 수, 작은 수)로 나눈 나머지를 구하고 (나머지, 작은 수)를 나눈 나머지를 구하기를
 * 반복하여 나머지가 0이 나올 때까지 반복하면 그때 의 작은 수가 최대공약수가 된다.
 * 최소공배수 : 두 수의 곱 / 최대 공약수(Largest Common Multiple)
 */
public class N개의_최소공배수 {
    public static int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = LCM(answer, arr[i]);
        }

        return answer;
    }

    //최소공배수 = a * b / 최대 공약수
    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }

    //최대공약수 구하는 공식
    public static int GCD(int a, int b) {
        //큰 수 비교
        if (a < b) {
            swap(a, b);
        }

        //나머지가 0이라면
        if (b == 0) {
            return a;
        } else {
            //다시 나누기
            return GCD(b, a % b);
        }
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14}));
    }
}
