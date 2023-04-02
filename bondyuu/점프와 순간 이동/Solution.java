import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        String bin = Integer.toBinaryString(n);
        bin = bin.replace("0","");
        ans = bin.length();

        return ans;
    }
}