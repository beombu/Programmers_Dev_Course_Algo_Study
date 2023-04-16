import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        int combi = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            combi *= (1 + entry.getValue());
        }

        return combi - 1;
    }
}