class Solution {
    public int[] solution(int brown, int yellow) {
    
        //단순 brute force 문제
        int[] answer = new int[2];
        int summ=brown+yellow;
        int col=0,i=0;
        for (i=1; i<=summ; i++){
            col=summ/i;
            if ((i-2)*(col-2)==yellow) break;
        }
        if (i>col) {
            int tmp=col;
            col=i;
            i=tmp;
        }
        answer[0]=col; answer[1]=i;
        return answer;

    }
}
