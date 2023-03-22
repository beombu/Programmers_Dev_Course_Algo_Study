class Solution {
    public int solution(int n) {
        String s = Integer.toBinaryString(n).replace("0","");
        int len = s.length();

        int k = n+1;
        while (true) {
            String t = Integer.toBinaryString(k);

            if(len == t.replace("0","").length()){
                return k;
            }
            k++;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(78));
    }
}