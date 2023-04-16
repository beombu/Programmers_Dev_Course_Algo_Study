package src._5주차;

import java.util.ArrayList;
import java.util.List;

public class n2배열자르기 {

    /**
     * 1. n행 n열 크기의 2차원 배열 생성
     * 2. 모든 빈칸 i로 채우기
     * 3. 행을 잘라내어 모두 이어붙인 새로운 1차월 배열 생성
     * 4. 새 1차원 배열의 left~right 행을 제외하고 지움.
     *
     * @param n     : 행과열의 크기
     * @param left  : 왼쪽 인덱스
     * @param right : 오른쪽 인덱스
     * @return : left~right 사이의 원소들
     */
    public static int[] solution(int n,
                                 long left,
                                 long right) {
        List<Integer> answer = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            answer.add((int) (Math.max(i/n, i%n) + 1));
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
