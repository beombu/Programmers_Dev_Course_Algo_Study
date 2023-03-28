public class 예상_대진표 {
    public static int solution(int n, int a, int b)
    {
        int answer = 0;
        int maxRound = (int) Math.sqrt(n) + 1;

        for (int i = 1; i <= maxRound; i++) {
            if (Math.abs(a - b) <= 1) {
                answer = i;
                break;
            }

            a = nextNum(a);
            b = nextNum(b);
        }

        return answer;
    }

    private static int nextNum(int x) {
        return (x / 2) + (x % 2);
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 5));
        System.out.println(solution(9, 4, 9));
    }
}
