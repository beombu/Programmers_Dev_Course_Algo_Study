import java.util.HashMap;

public class N개의_최소공배수 {
    public static int solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                if (arr[i] % j == 0) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }
            answer *= arr[i];
        }

        for (Integer key : map.keySet()) {
            System.out.println("key : " + key + " value : " + map.get(key));
            answer /= key;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14}));
    }
}
