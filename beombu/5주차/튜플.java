import java.util.*;

public class 튜플 {
    public int[] solution(String s) {
        List<List<Integer>> list = initList(s);
        int[] answer = new int[list.size()];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (!set.contains(list.get(i).get(j))) {
                    answer[i] = list.get(i).get(j);
                    set.add(list.get(i).get(j));
                }
            }
        }

        return answer;
    }

    private List<List<Integer>> initList(String s) {
        StringTokenizer st = new StringTokenizer(s.substring(1, s.length() - 1), "}");
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < st.countTokens(); i++) {
            list.add(new ArrayList<>());
        }

        int idx = 0;
        String tmp = st.nextToken().substring(1);
        StringTokenizer st1 = new StringTokenizer(tmp, ",");
        while (st1.hasMoreTokens()) {
            list.get(idx).add(Integer.parseInt(st1.nextToken()));
        }
        idx++;

        while (st.hasMoreTokens()) {
            tmp = st.nextToken().substring(2);
            st1 = new StringTokenizer(tmp, ",");
            while (st1.hasMoreTokens()) {
                list.get(idx).add(Integer.parseInt(st1.nextToken()));
            }
            idx++;
        }

        list.sort(Comparator.comparingInt(List::size));
        return list;
    }
}
