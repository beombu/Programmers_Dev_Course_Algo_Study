import java.util.HashSet;

/**
 * Time : O(N^3)
 */
public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hashSet = new HashSet<>();

        for (String str : phone_book) {
            hashSet.add(str);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hashSet.contains(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}