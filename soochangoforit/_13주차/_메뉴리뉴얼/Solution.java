import java.util.*;

class Solution {
    // course 개수에 따라 메뉴 조합의 종류를 담을 Map, course가 달라지면 초기화 작업 필요
    HashMap<String, Integer> combiMapEachCourse;
    // course 개수에 따라 최대로 많이 찾아줬던 조합의 개수, course가 달라지면 초기화 작업 필요 
    int maxCntEachCourse;
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> ansOfList = new ArrayList<>();
        
        // 1. 사용자가 만들고자 하는 course 구성에 맞게 조합 만들 필요
        for(int tgMenuCount : course) {
            // (중요) course 가 변경될때마다 max 값을 0으로 update 필요
            // 0으로 초기화 하지 못하는 경우, max 값이 앞전 경우의 수가 max로 잡혀서 올바른 결과 X
            // map 또한 원래 HashMap으로 초기화 필요, 
            // 초기화 하지 못 하는 경우, 현재 course에서 나올 수 있는 조합에 대해서만 max와 비교 필요
            combiMapEachCourse = new HashMap<>();
            maxCntEachCourse = 0;
            
            // 2. 손님이 주문한 모든 orders를 순회하면서 course에 맞는 조합 만들 필요.
            for(String order : orders) {
                // 3. order 기준으로 매번 정렬한 상태로 조합을 구한다.
                char[] orderChars = order.toCharArray();
                Arrays.sort(orderChars);
                
                // 4. 조합을 만드는 DFS 수행 (startIdx, 하나의 코스를 구성하기 위한 메뉴 개수, 조합문자열, 정렬된 문자열)
                combination(0, tgMenuCount, "", orderChars);
            }
            
            
            for(String key : combiMapEachCourse.keySet()){
                int count = combiMapEachCourse.getOrDefault(key, 0);
								// 7. 최대로 많이 찾아준 조합의 경우와 2명의 손님이 적어도 찾아야 한다.
                if (count == maxCntEachCourse && count > 1){
                    ansOfList.add(key);
                }
            }

        }
        
        // 출력을 위한 오름 차순 정렬
        return ansOfList.stream().sorted().toArray(String[]::new);

    }
    
    
    void combination(int startIdx, int tgMenuCount, String combi, char[] orderChars) {
        // 6. String combi에 담긴 문자열의 길이가 코스로 구성하고자 하는 메뉴 사이즈와 같다면
        // DFS return
        if(combi.length() == tgMenuCount) {
            int prevCnt = combiMapEachCourse.getOrDefault(combi, 0);
            int newCnt = prevCnt + 1;
            combiMapEachCourse.put(combi, newCnt);
            maxCntEachCourse = Math.max(maxCntEachCourse, newCnt);
            return;
        }
        // 5. startIdx 부터 시작해서 만들수 있는 조합 문자를 String combi에 넣는다.
        for(int start = startIdx; start < orderChars.length; start++) {
            char menu = orderChars[start];
            combination(start + 1, tgMenuCount, combi + menu, orderChars);
        }
    }
}