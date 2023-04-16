package src._4주차;

import java.util.*;
import java.util.stream.Collectors;

public class 귤고르기 {

    /**
     *
     * @param k : 경화가 사고 싶은 귤 갯수
     * @param tangerine : 수확한 귤 크기
     * @return :
     */
    public int solution(int k,
                        int[] tangerine) {

        int answer = 0;
        int sum = 0;

        Map<Integer, Integer> map = Arrays.stream(tangerine)
                .boxed()
                .collect(Collectors.toMap(
                        key -> key,
                        value -> 1,
                        Integer::sum
                ));

        List<Integer> list = map.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for(int i : list){
            answer++;
            sum = sum+i;

            if(sum>=k)
                break;
        }
        
        return answer;
    }
}
