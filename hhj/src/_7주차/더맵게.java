package src._7주차;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 더맵게 {

    /**
     * 모든 음식의 스코빌 지수를 K이상으로 만들 것.
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두번째로 맵지 않은 스코빌 지수*2)
     *
     * @param scoville : 모든 음식의 스코빌 지수를 담은 배열
     * @param K : 원하는 스코빌 지수
     * @return : 섞어야 하는 최소 횟수
     */
    public static int solution(int[] scoville,
                               int K) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int count = 0;

        for(int s : scoville){
            priorityQueue.offer(s);
        }

        while(priorityQueue.peek() < K){

            if(priorityQueue.size() < 2){
                return -1;
            }

            int first = priorityQueue.poll();
            int second = priorityQueue.poll();

            priorityQueue.offer(first + (second*2));
            count++;
        }

        return count;
    }
}
