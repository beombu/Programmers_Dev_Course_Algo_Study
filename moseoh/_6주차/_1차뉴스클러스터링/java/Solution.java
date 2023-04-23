package _6주차._1차뉴스클러스터링.java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(new Solution().solution(str1, str2));
    }

    public int solution(String str1, String str2) {
        List<String> list1 = getList(str1);
        List<String> list2 = getList(str2);

        return (int) Math.floor(getJaccardSimilarity(list1, list2) * 65536);
    }

    public List<String> getList(String str1) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String element = str1.substring(i, i + 2);
            if (element.matches("[a-zA-Z]*")) {
                list.add(str1.substring(i, i + 2).toLowerCase());
            }
        }
        return list;
    }

    // intersection 교집합
    public double getJaccardSimilarity(List<String> list1, List<String> list2) {
        int intersectionSize = 0;
        boolean[] visited = new boolean[list2.size()];

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (visited[j]) continue;
                if (list1.get(i).equals(list2.get(j))) {
                    intersectionSize++;
                    visited[j] = true;
                    break;
                }
            }
        }


        int unionSize = list1.size() + list2.size() - intersectionSize;
        if (intersectionSize == 0 && unionSize == 0) return 1;
        if (intersectionSize == 0) return 0;
        return (double) intersectionSize / unionSize;
    }
}
