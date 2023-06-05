package soochangoforit._13����._���ӵ�_�κ�_������_��;

import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int start = 0;
        int end = 0;
        // sum�� �ʱ� index 0 ������ ����
        int sum = sequence[0];
        int minLength = Integer.MAX_VALUE;
        // answer���� �ܼ��� ���� index�� �� index�� ���⿡ size�� 2�θ� �Ѵ�.
        int[] answer = new int[2];
        
        // 2���� �����͸� �պ��� 
        while (end < sequence.length) {
            // sum�� �����ϸ鼭 ���� ���� ���� ���̰� ª�� ���
            if (sum == k && end - start + 1 < minLength) {
                answer[0] = start;
                answer[1] = end;
                // ���� ª�� ���̸� �ʱ�ȭ
                minLength = end - start + 1;
            }
            
            // sum�� k ���� ���� ��� �Ǵ� ���� ���
            // ���� ���� ���� ����� ���� ���� end�� �ű� �ʿ䰡 �ִ�.
            // k ���� ���� ���� �Ϲ������� ���� ������Ű�� ���� end ��ġ�� �ű��.
            if (sum <= k) {
                // �⺻������ k���� ���� ��� end�� �÷��� ���� ũ�� ����� �Ѵ�.
                end++;
                // end�� ���� �� �ȿ��� �����̸�, �����϶����� sum�� ���� �� ���ش�.
                if (end < sequence.length) {
                    sum += sequence[end];
                }
                // end ���� ������ ����� ��� while�� Ż���ϸ鼭 answer�� �����Ѵ�.
            } 
            // �̹� k���� ū ���� 
            // ������ ������ ���� ���� start ��ġ�� ���� sum���� ����, start ��ġ�� ���� �ű��.
            else {
                sum -= sequence[start];
                start++;
            }
        }
        
        return answer;
    }
}
