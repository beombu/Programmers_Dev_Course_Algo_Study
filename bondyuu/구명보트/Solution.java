import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int k = 0;

        for (int i = people.length - 1; i>=k; i--){
            if(people[k] + people[i] > limit){
                answer++;
            } else {
                answer++;
                k++;
            }
        }

        return answer;
    }
}