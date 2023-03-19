class Solution {
    boolean solution(String s) {
        int count=0;
        for (char c : s.toCharArray()){
            if (c=='(') count+=1;
            else count-=1;
            if (count<0) return false;
        }
        
        if (count==0) return true;
        else return false;
    }
}