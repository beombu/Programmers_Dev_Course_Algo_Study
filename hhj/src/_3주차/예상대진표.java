package src._3주차;

public class 예상대진표 {
    static int answer = 0;

    /**
     * 토너먼트 형식
     * 승자는 앞 번호를 부여 받음.
     * a번, b번 참가자는 항상 승리
     * 부전승은 없음.
     * @param n : n명의 참가자
     * @param a : a번 참가자.
     * @param b : b번 참가자.
     * @return : a번 참가자와 b번 참가자가 만나는 라운드 값
     */
    public static int solution(int n,
                               int a,
                               int b) {
        game(a, b);
        return answer;
    }

    public static void game(int a,
                            int b){
        if(a==b)
            return;

        answer++;
        game(a/2 + a%2, b/2 + b%2);
    }
}
