import java.util.*;

class Solution {
    public int solution(int n) {

        /*
        소요 시간 : 20분 
        문제 해결 알고리즘 : 구간 합을 set를 이용하여 해결 
        이 알고리즘을 떠올린 과정 
        1.  1~a 전체 구간에서의 값을 사용하는 게 아니라 DP는 못 씀.
          b~a처럼 '연속적인 구간 합'을 이용해야 함.
          => 구간 합(누적 합)을 이용해야 하는구나
        2. 미리 구간 합을 1~n까지 다 구해놓고,
          O(n*n)을 기반으로, 가지치기를 하며 count해주는 방법 
            => 백준 기준 java 1초라면 통과했을 거 같은데,
             여기 프로그래머스에서는 더 효율적인 방법이 있어서 그런지 시간효율에서 통과 못함
        3. O(n)으로 해결 가능. 순회하며 구간 합을 구하면서, 
          이전에 나왔던 구간합을 set에 담아놓고 그 값이 있는지(=정답을 만들어 줄 수 있는지) 
           딱 1번만 검사하면 된다.  
            => 정답 
        */

        //1 to 10000 합이 5000만정도라 visited말고 set이용
        HashSet<Integer> set=new HashSet<Integer>();
        int sum=0;
        int count=0;
        for (int i=0; i<=n; i++){ //시간복잡도 O(N)
            sum+=i;
            if (set.contains(sum-n))  count++;
            set.add(sum);
        }
        return count;
        
        /*//O(n*n) 누적 합 이용.  정답은 잘 나오나, 시간효율에서 통과 못함.
        int[] l= new int[n+1];
        int sum=0;
        int tmp;
        int count=0;
        for (int i=0; i<=n; i++){
            sum+=i;
            l[i]=sum;
        }
        
        //언뜻 보면 n^2나, 가지치기가 잘 되어있음.
        for (int i=n; i>=0; i--){
            if (l[i]<n) continue;
            for (int j=n-1; j>=0; j--){
                tmp=l[i]-l[j];
                if (tmp==n) count++;
                else if (tmp>n) break;
            }
        } return count;
        //근데 여기선 통과가 안되네..?ㅎ visited나 set 쓰자
        */
        
    
        
    }
}