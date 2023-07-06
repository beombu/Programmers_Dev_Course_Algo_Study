import java.util.*;

public class Solution {
    List<Set<Integer>> candidateKeys;
    String[][] relation;
    int colSize;

    public int solution(String[][] relation) {
        this.relation = relation;
        this.colSize = relation[0].length;
        this.candidateKeys = new ArrayList<>();

        // i 는 1 ~ 4 (열 4개 테이블 기준)
        for (int i = 1; i <= colSize; i++) {
            makeCombinations(0, 0, i, new HashSet<>());
        }

        return candidateKeys.size();
    }

    /**
     * @param start 조합을 생성할 시작 인덱스
     * @param depth 현재 조합의 길이
     * @param target 목표하고자 하는 조합의 길이
     * @param columns 현재까지 뽑은 조합의 집합
     */
    private void makeCombinations(int start, int depth, int target, Set<Integer> columns) {

        // if 문 안에서는 dept, target, columns 값을 고려하면 된다.
        if (depth == target) {
            // {후보키가 될 수 있을지 없을지 모르는 column(열) 집합}이 {이미 기존 유일성과 최소성을 만족하는 key}을 포함하고 있으면 : 최소성을 만족하지 못 해 return 필요.
            // 즉, 최소성을 만족하지 못 하는 경우
            for (Set<Integer> keySet : candidateKeys) {
                if (columns.containsAll(keySet)) return;
            }

            // 최소성은 만족하지만, 유일성도 만족하는지 여부
            if (checkUniqueness(columns)) {
                // 유일성도 만족한다면 최종적으로 후보키가 될 수 있다.
                candidateKeys.add(columns);
            }
            return;
        }

        for (int i = start; i < colSize; i++) {
            // 재귀 호출이 columns의 독립적인 복사본을 사용
            //  한 재귀 호출에서 columns의 상태를 변경해도 다른 재귀 호출에는 영향을 주지 않는다.
            Set<Integer> newSet = new HashSet<>(columns);
            newSet.add(i);
            makeCombinations(i + 1, depth + 1, target, newSet);
        }
    }

    /**
     * @param columns 현재까지 뽑은 조합의 집합
     */
    private boolean checkUniqueness(Set<Integer> columns) {
        List<String> tuples = new ArrayList<>();

        // 조합 columns 에 있는 "후보키가 될 수도 있고 안될수도 있는" 키들의 열을 뽑는다.
        // 모든 가로 줄 tuple을 가져온다.
        for (String[] tuple : relation) {
            // 하나의 row에서 column에 해당하는 모든 문자열을 하나로 합친다.
            // ex) 100ryanmusic2
            // column 1 index 만 고려하는 경우, tuples에 "ryan", "apeach", "tube", "con", "muzi", "apeach" 가 된다.
            StringBuilder sb = new StringBuilder();
            for (int column : columns) {
                sb.append(tuple[column]);
            }
            tuples.add(sb.toString());
        }

        // columns 기준으로 만든, 모든 tuple들의 집합이 중복되지 않는다면, 후보키가 될 수 있다.
        Set<String> uniqueTuples = new HashSet<>(tuples);
        int rowCount = relation.length;

        return uniqueTuples.size() == rowCount;
    }

}
