package src._7주차;

import java.util.StringTokenizer;

public class K진수에서소수개수구하기 {

    /**
     * 양의 정수 n의 k진수로 바꿨을 때
     * - 0P0처럼 소수 양쪽에 0이 있는 경우
     * - P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
     * - 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
     * - P처럼 소수 양쪽에 아무것도 없는 경우
     * - 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
     * - 예를 들어, 101은 P가 될 수 없습니다.
     *
     * @param n : 값
     * @param k : 진수 : K의 값은 10 이하이기 때문에 변환에서 다른 조건 생각하지 않아도 됨.
     * @return : 위 조건에 맞는 소수 개수
     */
    public static int solution(int n,
                               int k) {

        String number = toNPrime(n, k);

        StringTokenizer stringTokenizer = new StringTokenizer(number, "0");

        int answer = 0;

        while (stringTokenizer.hasMoreTokens()) {

            if (isPrime(Long.parseLong(stringTokenizer.nextToken()))) {
                answer++;
            }
        }

        return answer;
    }


    public static boolean isPrime(long number) {

        long midNumber = (long) (Math.sqrt(number) + 1);

        if (number < 2) {
            return false;
        }

        for (int i = 2; i < midNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static String toNPrime(int n,
                                  int k) {

        if (n == 0) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (n > 0) {
            stringBuilder.append(n % k);
            n /= k;
        }

        return stringBuilder.reverse().toString();
    }
}
