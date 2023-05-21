import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //ex) 6, 10, 2일때 610과 106을 비교하여 내림차순 정렬
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (String str : strArr) {
            answer += str;
        }

        if (strArr[0].equals("0")) {
            answer = "0";
        }

        return answer;
    }
}
