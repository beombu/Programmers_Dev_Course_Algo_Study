package src._2주차;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;

        for(int i=n; i>0; i--){
            int startIndex = i;
            int sum = 0;

            while(startIndex>0){
                sum += startIndex;
                if(sum == n){
                    answer++;
                    break;
                }
                else if(sum > n){
                    break;
                }
                startIndex--;
            }
        }

        return answer;
    }
}
