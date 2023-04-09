class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;

        while (true) {
            int A = (a+1)/2;
            int B = (b+1)/2;

            if(A == B) {
                break;
            }
            a = A;
            b = B;
            answer++;

        }


        return answer;
    }
}