package src._2주차;

import java.util.Stack;

public class 영어끝말잇기 {
    static Stack<String> stack = new Stack<>();
    public static int[] solution(int n,
                          String[] words) {
        return gameStart(n, words);
    }

    public static int[] gameStart(int n,
                          String[] words){
        int index = 0;
        int userCount = 1;
        int failUserNumber = 2;

        stack.push(words[index++]);
        while(index < words.length){
            String nextWord = words[index++];

            if(stack.contains(nextWord)){
                return new int[]{failUserNumber, userCount};
            }else if(stack.peek().charAt(stack.peek().length()-1) != nextWord.charAt(0)){
                return new int[]{failUserNumber, userCount};
            }

            stack.push(nextWord);

            if(failUserNumber == n){
                failUserNumber = 1;
                userCount++;
            }else{
                failUserNumber++;
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        String[] s = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] answer = solution(3, s);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
