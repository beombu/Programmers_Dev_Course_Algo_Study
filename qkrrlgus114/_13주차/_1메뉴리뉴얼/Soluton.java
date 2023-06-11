import java.util.*;
class Solution {
    Map<String, Integer> hashMap = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> solution(String[] orders, int[] course) {
        // 1. orders를 정렬.
        // 2. 각 코스 길이별로 조합 만들어서 Map에 저장
        // 3. Map에서 최고 개수를 result 배열에 저장.
        // -------------------------------------------------------

        // 1. orders 정렬
        for(int i=0; i<orders.length; i++){
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }

        // 2. 각 코스별로 조합 만들어서 최댓값 Map에 저장.
        for(int i=0; i<course.length; i++){
            for(int j=0; j<orders.length; j++){
                combination("", orders[j], course[i]);
            }
            // 최댓값을 찾아야함.(Map에서)
            if(!hashMap.isEmpty()){ // 맵이 비어있지 않으면
                List<Integer> tempList = new ArrayList<>(hashMap.values()); // 밸류값 전부 리스트에 저장
                int max = Collections.max(tempList); // 최댓값 뽑아내기
                if(max>1){ // 메뉴는 최소 2개 이상이므로
                    for(String key : hashMap.keySet()){
                        if(max == hashMap.get(key)){
                            result.add(key);
                        }
                    }
                }

                hashMap.clear();
            }

        }
        Collections.sort(result);
        return result;

    }

    public void combination(String curr, String other, int count){ // 현재까지 조합, 앞으로 써야 되는 알파벳, 남은 코스 카운트
        // 종료 조건
        if(count == 0){ // count==0이면 course 만족
            if(hashMap.get(curr)==null){
                hashMap.put(curr, 1);
            }else{
                int res = hashMap.get(curr);
                hashMap.put(curr, res+1);
            }
            return;
        }

        // 재귀 조건
        for(int i=0; i<other.length(); i++){
            combination(curr+other.charAt(i), other.substring(i+1), count-1);
        }
    }
}