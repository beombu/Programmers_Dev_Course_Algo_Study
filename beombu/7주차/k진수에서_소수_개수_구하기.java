/**
 * Time : O(n^2)
 * 소수 문제 에라토스테네스의 체(isPrime) 외우기!!
 * => 2 ~ n의 제곱근까지 반복하면서 n이 반복하는 수로 나누어 떨어지면 소수X
 */
public class k진수에서_소수_개수_구하기 {
    public static int solution(int n, int k) {
        int answer = 0;
        String[] convertNum = getConvert(n, k);

        for (String str : convertNum) {
            if (str.equals("")) {
                continue;
            }

            long num = Long.parseLong(str);

            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private static String[] getConvert(int n, int k) {
        return Integer.toString(n, k).split("0");
    }

    private static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        solution(437674, 3);
        solution(110011, 10);
    }
}
