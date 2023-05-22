import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int count = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        push(right, topping);

        for (int i = 0; i < topping.length - 1; i++) {

            if (right.size() >= left.size()) {
                push(left, topping[i]);
                pop(right, topping[i]);
            } else {
                break;
            }

            if (right.size() == left.size()) {
                count++;
            }
        }

        return count;
    }

    public void push(Map<Integer, Integer> map, int[] toppings) {
        for (int topping : toppings) {
            if (!map.containsKey(topping)) {
                map.put(topping, 0);
            }
            map.put(topping, map.get(topping) + 1);
        }
    }

    public void push(Map<Integer, Integer> map, int topping) {
        if (!map.containsKey(topping)) {
            map.put(topping, 0);
        }
        map.put(topping, map.get(topping) + 1);
    }

    public void pop(Map<Integer, Integer> map, int topping) {
        map.put(topping, map.get(topping) - 1);
        if (map.get(topping) == 0) {
            map.remove(topping);
        }
    }
}
