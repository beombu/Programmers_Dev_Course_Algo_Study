import java.util.HashSet;

public class 소수_찾기 {
    static boolean[] visited;
    static String[] nums;
    static HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        nums = numbers.split("");
        visited = new boolean[numbers.length()];

        dfs("", 0);
        return set.size();
    }

    private void dfs(String str, int idx) {
        if (!str.equals("")) {
            if (isPrime(Integer.parseInt(str))) {
                set.add(Integer.parseInt(str));
            }
        }

        if (nums.length == idx) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(str + nums[i], idx + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
