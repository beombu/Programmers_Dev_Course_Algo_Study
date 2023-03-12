import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        NewList newList = new NewList(s);

        int min = newList.getMin();
        int max = newList.getMax();

        return min + " " + max;
    }

    class NewList {
        private List<Integer> items;

        public NewList(String str) {
            this.items = Arrays.stream(str.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            this.items.sort(Collections.reverseOrder());
        }

        public Integer getMin() {
            return items.get(items.size()-1);
        }

        public Integer getMax() {
            return items.get(0);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("1 2 3 4"));
        System.out.println(sol.solution("-1 -2 -3 -4"));
        System.out.println(sol.solution("-1 - 1"));
    }
}