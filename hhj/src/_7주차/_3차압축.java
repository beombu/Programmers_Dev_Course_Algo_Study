package src._7주차;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3차압축 {

    static int index = 0;

    /**
     * Lempel-Ziv-Welch 압축 구현
     * - 길이가 1인 모든 단어를 포함하도록 사전을 초기화 - O
     * - 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다. - O
     * - w에 해당하는 사전의 색인 번호를 출력하고 입력해서 제거한다.
     * - 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어 사전에 등록
     * - 단계 2로 돌아간다.
     *
     * @param msg
     * @return
     */
    public static int[] solution(String msg) {

        Map<String, Integer> map = mapInit();

        List<Integer> answer = new ArrayList<>();

        msg.toUpperCase();

        while (!msg.isBlank()){

            int size = msg.length();

            while (true){
                String w = msg.substring(0, size);

                if(map.containsKey(w)){
                    answer.add(map.get(w));

                    if(size < msg.length()){
                        map.put(w + msg.charAt(size), ++index);
                    }

                    break;
                }

                size--;
            }

            msg = msg.substring(size);
        }

        return answer
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static HashMap<String, Integer> mapInit() {

        HashMap<String, Integer> map = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c + "", ++index);
        }

        return map;
    }

    public static void main(String[] args) {

        int[] arr = solution("KAKAO");

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i] + "");
        }

    }
}
