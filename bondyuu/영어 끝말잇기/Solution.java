import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> list = new HashSet<>();
        list.add(words[0]);
        for(int i = 1; i < words.length; i++){

            if (words[i-1].charAt(words[i-1].length()-1) == words[i].charAt(0) && !list.contains(words[i])){
                list.add(words[i]);
                continue;
            }
            answer[0] = i % n + 1;
            answer[1] = i / n + 1;
            break;
        }


        return answer;
    }
}