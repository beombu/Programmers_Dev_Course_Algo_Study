class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");

        for (int i = 0; i < arr.length; i++) {
            if(i == 0 || arr[i-1].equals(" ")) {
                answer += arr[i].toUpperCase();
            } else {
                answer += arr[i].toLowerCase();
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("for the last week"));
    }
}