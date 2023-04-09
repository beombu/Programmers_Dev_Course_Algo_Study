import java.util.Arrays;

/**
 * Time : O(n log n)
 */
public class 구명보트 {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;//가벼운 사람
        int right = people.length - 1;//무거운 사람

        while (left <= right) {
            int weight = people[right--];

            //2명을 구출하는 경우
            if (people[left] + weight <= limit) {
                left++;
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{40,40,40,40,40},  240));
    }
}
