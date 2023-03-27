package _3주차.구명보트.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] people1 = {70, 50, 80, 50};
        int limit1 = 100;
        assert new Solution().solution(people1, limit1) == 3 : "실패";

        int[] people2 = {70, 80, 50};
        int limit2 = 100;
        assert new Solution().solution(people2, limit2) == 3 : "실패";
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int index = people.length - 1;
        for (int i = 0; i <= index; i++, answer++)
            while (index > i && people[i] + people[index--] > limit)
                answer++;

        return answer;
    }
}
