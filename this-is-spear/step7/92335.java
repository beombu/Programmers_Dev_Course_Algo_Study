class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String string = Integer.toString(n, k);
        String[] split = string.split("0");
        for (String number : split) {
            if (number.isBlank()) {
                continue;
            }

            if (isPrimeNumber(number)) {
                answer += 1;
            }
        }
        return answer;
    }

    private boolean isPrimeNumber(String number) {
        long num = Long.parseLong(number);

        if (num == 1) {
            return false;
        }

        int a = (int) Math.sqrt(num);

        for (int i = 2; i <= a; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
