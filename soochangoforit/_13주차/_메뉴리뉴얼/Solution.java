package _13����._�޴�������;

import java.util.*;

class Solution {
    // course ������ ���� �޴� ������ ������ ���� Map, course�� �޶����� �ʱ�ȭ �۾� �ʿ�
    HashMap<String, Integer> combiMapEachCourse;
    // course ������ ���� �ִ�� ���� ã����� ������ ����, course�� �޶����� �ʱ�ȭ �۾� �ʿ� 
    int maxCntEachCourse;
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> ansOfList = new ArrayList<>();
        
        // 1. ����ڰ� ������� �ϴ� course ������ �°� ���� ���� �ʿ�
        for(int tgMenuCount : course) {
            // 1-1. �Ź� course ���� �ʱ�ȭ �۾� �ʿ�
            combiMapEachCourse = new HashMap<>();
            maxCntEachCourse = 0;
            
            // 2. �մ��� �ֹ��� ��� orders�� ��ȸ�ϸ鼭 course�� �´� ���� ���� �ʿ�.
            for(String order : orders) {
                // 3. order �������� �Ź� ������ ���·� ������ ���Ѵ�.
                char[] orderChars = order.toCharArray();
                Arrays.sort(orderChars);
                
                // 4. ������ ����� DFS ���� (startIdx, �ϳ��� �ڽ��� �����ϱ� ���� �޴� ����, ���չ��ڿ�, ���ĵ� ���ڿ�)
                combination(0, tgMenuCount, "", orderChars);
            }
            
            
            for(String key : combiMapEachCourse.keySet()){
                int count = combiMapEachCourse.getOrDefault(key, 0);
                if (count == maxCntEachCourse && count > 1){
                    ansOfList.add(key);
                }
            }

        }
        
        // ����� ���� ���� ���� ����
        return ansOfList.stream().sorted().toArray(String[]::new);

    }
    
    
    void combination(int startIdx, int tgMenuCount, String combi, char[] orderChars) {
        // 6. String combi�� ��� ���ڿ��� ���̰� �ڽ��� �����ϰ��� �ϴ� �޴� ������� ���ٸ�
        // DFS return
        if(combi.length() == tgMenuCount) {
            int prevCnt = combiMapEachCourse.getOrDefault(combi, 0);
            int newCnt = prevCnt + 1;
            combiMapEachCourse.put(combi, newCnt);
            maxCntEachCourse = Math.max(maxCntEachCourse, newCnt);
            return;
        }
        // 5. startIdx ���� �����ؼ� ����� �ִ� ���� ���ڸ� String combi�� �ִ´�.
        for(int start = startIdx; start < orderChars.length; start++) {
            char menu = orderChars[start];
            combination(start + 1, tgMenuCount, combi + menu, orderChars);
        }
    }
}