import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int n=people.length;
        int ans=0,a=0,b;
        Arrays.sort(people);
        
        for (b=n-1;a<=b;b--) {
            if (people[a]+people[b]<=limit) a++;
            ans++; //보트는 무조건 한 대는 보냄
        }
        
        return ans;
    }
}
