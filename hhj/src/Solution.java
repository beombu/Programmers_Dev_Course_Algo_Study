package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] input1 = new int[]{1, 3, 5, 6, 7, 10};  //YES
    static int[] input2 = new int[]{1, 3, 5, 6, 7, 20};  //YES : 3+5+6+7 = 21 = 20+1
    static int[] input3 = new int[]{1, 3, 5, 6, 7, 22};  //YES
    static int size = 6;

    static int totalSum = 0;
    static String answer = "NO";
    static boolean flag = false;

    public static void main(String[] args) {
        for (int i : input1) {
            totalSum += i;
        }

        dfs(1, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int sum) {
        if (flag) return;

        if (totalSum < 2 * sum) return;

        if (depth == size) {
            if (totalSum == 2 * sum) {
                answer = "YES";
                flag = true;
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            dfs(depth + 1, sum + input1[i]);
            dfs(depth + 1, sum);
        }
    }
}
