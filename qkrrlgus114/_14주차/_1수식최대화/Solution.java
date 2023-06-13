import java.util.*;

class Solution {
    static int[] per; // 수식은 3개니깐 순열을 넣을 배열
    static boolean[] visited; // 방문체크
    static String[] arr = {"+", "-", "*"};
    static List<String> aList = new ArrayList<>();
    static Long max = 0L;

    public long solution(String expression) {
        per = new int[3];
        visited = new boolean[3];
        int start = 0;
        // 우선 리스트에 숫자랑 기호를 전부 잘라서 넣음
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)=='+'|| // 수식이면
                    expression.charAt(i)=='*'||
                    expression.charAt(i)=='-'){
                aList.add(expression.substring(start,i));
                aList.add(String.valueOf(expression.charAt(i)));
                start = i+1;
            }
        }
        aList.add(expression.substring(start));
        permutation(0);
        return max;
    }

    public void permutation(int depth){
        // 종료 조건
        if(depth == 3){
            List<String> list = new ArrayList<>(aList); // aList랑 똑같은 리스트 생성
            for(int i=0; i<per.length; i++){
                int size = list.size();
                for(int j=0; j<size; j++){
                    if(list.get(j).equals(arr[per[i]])){
                        Long num1 = Long.parseLong(list.get(j-1));
                        Long num2 = Long.parseLong(list.get(j+1));
                        Long result = 0L;

                        if(list.get(j).equals("-")){
                            result = num1 - num2;
                        }else if(list.get(j).equals("+")){
                            result = num1 + num2;
                        }else if(list.get(j).equals("*")){
                            result = num1 * num2;
                        }
                        for(int k=0; k<3; k++){
                            list.remove(j-1);
                        }
                        list.add(j-1, String.valueOf(result));
                        j-=1;
                        size-=2;
                    }
                }
            }
            // 맥스값 비교해서 갱신
            max = Math.max(max, Math.abs(Long.parseLong(list.get(0))));
        }

        // 재귀 조건
        for(int i=0; i<3; i++){ // 수식이 3개라서
            if(!visited[i]){
                visited[i] = true;
                per[depth] = i;
                permutation(depth+1);
                visited[i] = false;
            }
        }
    }
}