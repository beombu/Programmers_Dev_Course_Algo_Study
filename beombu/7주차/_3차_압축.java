import java.util.ArrayList;
import java.util.HashMap;

public class _3차_압축 {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int indexNumber = 27;
        int preIndexNumber = 0;

        init(map);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            sb.append(msg.charAt(i));

            if (map.containsKey(sb.toString())) {
                preIndexNumber = map.get(sb.toString());
            } else {
                map.put(sb.toString(), indexNumber++);
                answer.add(preIndexNumber);

                //다시 세팅
                preIndexNumber = 0;
                sb.setLength(0);
                i--;
            }
        }

        if (preIndexNumber != 0) {
            answer.add(preIndexNumber);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void init(HashMap<String, Integer> map) {
        String[] alphabet = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < 26; i++) {
            map.put(alphabet[i], i + 1);
        }
    }
}
