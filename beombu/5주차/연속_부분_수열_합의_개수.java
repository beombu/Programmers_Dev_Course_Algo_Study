import java.util.HashSet;

public class 연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        for (int size = 1; size <= elements.length; size++) {
            for (int i = 0; i < elements.length; i++) {
                int num = 0;
                for (int j = 0; j < size; j++) {
                    int idx = (i + j) % elements.length;
                    num += elements[idx];
                }
                set.add(num);
            }
        }
        return set.size();
    }
}
