import java.math.*;

class Solution
{
    public int solution(int n, int a, int b)
    {

        int count=0;
        //2^20=1048576
        while (true){
            if (a==b) break;
            
            a= (int) Math.ceil( (double) a/2);
            b= (int) Math.ceil( (double) b/2);
            System.out.println(a+" "+b);
            count++;
        }
        
        return count;
    }
}
