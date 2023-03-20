class Solution {
    public int solution(int n) {
        int a=0;
        int b=1;
        int tmp;
        //int n=100000;
        for(int i=0;i<n-1;i++){
            tmp=b%1234567;
            b=((a+b)%1234567);
            a=tmp;
            //System.out.println(a);
            //System.out.println(b);
        }
        return b%1234567;
    }
}