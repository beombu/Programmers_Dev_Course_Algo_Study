import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class H_Index {
    public static int solution(int[] citations) {
        int answer = 0;
        int paperCnt = 0;//논문의 수

        List<Integer> citationsList = Arrays.stream(citations).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i : citationsList) {
            int citationCnt = i;//인용 횟수

            if (citationCnt < paperCnt + 1) {
                answer = paperCnt;
                break;
            }

            if (paperCnt == citationsList.size() - 1) {//마지막 인덱스 인 경우
                answer = paperCnt + 1;
            }

            paperCnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,0,6,1,5}));
        System.out.println(solution(new int[]{33,44,55,12}));
    }
}
