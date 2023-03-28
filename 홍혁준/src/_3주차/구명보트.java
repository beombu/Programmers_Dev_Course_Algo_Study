package src._3주차;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class 구명보트 {

    public static int solution(int[] people,
                               int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length-1;

        Arrays.sort(people);

        while (left <= right){
            int currentWeight = people[right--];

            if(people[left] + currentWeight <= limit){
                left++;
            }
            answer++;
        }

        return answer;
    }

    //Deque 사용 : 시간초과
    public static int dequeSolution(int[] people,
                                    int limit) {
        int answer = 0;
        int currentWeight = limit;

        Deque<Integer> deque = new LinkedList<>(Arrays.stream(people).boxed().sorted().collect(Collectors.toList()));

        while (!deque.isEmpty()){
            currentWeight -= deque.pollLast();

            if(!deque.isEmpty() && currentWeight >= deque.peekFirst()){
                deque.pollFirst();
            }

            currentWeight = limit;
            answer++;
        }

        return answer;
    }
}
