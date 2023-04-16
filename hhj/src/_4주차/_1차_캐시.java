package src._4주차;

import java.util.LinkedList;
import java.util.Queue;

public class _1차_캐시 {

    /**
     * DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램
     * 조건
     *  - 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용
     *  - cache hit일 경우 실행시간 = 1
     *  - cache miss일 경우 실행시간 = 5
     * @param cacheSize : 캐시 크기
     * @param cities : 도시 이름들
     * @return : 총 실행시간
     */
    public static int solution(int cacheSize,
                               String[] cities) {

        if(cacheSize == 0)
            return cities.length * 5;

        return getTotalTime(cacheSize, cities);
    }

    public static int getTotalTime(int cacheSize,
                                   String[] cities){
        int totalTime = 0;
        Queue<String> queue = new LinkedList<>();

        for(int i=0; i<cities.length; i++){
            String temp = cities[i].toLowerCase();

            if(queue.isEmpty()){
                queue.offer(temp);
                totalTime += 5;
            }else if(queue.contains(temp)){
                queue.remove(temp);
                queue.offer(temp);
                totalTime += 1;
            }else if(queue.size() == cacheSize){
                queue.poll();
                queue.offer(temp);
                totalTime += 5;
            }else{
                queue.offer(temp);
                totalTime += 5;
            }
        }

        return totalTime;
    }
}
