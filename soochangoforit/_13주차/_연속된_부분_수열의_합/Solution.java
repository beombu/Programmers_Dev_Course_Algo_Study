package soochangoforit._13주차._연속된_부분_수열의_합;

import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int start = 0;
        int end = 0;
        // sum은 초기 index 0 값으로 설정
        int sum = sequence[0];
        int minLength = Integer.MAX_VALUE;
        // answer에는 단순히 시작 index와 끝 index가 들어가기에 size를 2로만 한다.
        int[] answer = new int[2];
        
        // 2개의 포인터를 앞부터 
        while (end < sequence.length) {
            // sum을 만족하면서 앞전 보다 제일 길이가 짧은 경우
            if (sum == k && end - start + 1 < minLength) {
                answer[0] = start;
                answer[1] = end;
                // 제일 짧은 길이를 초기화
                minLength = end - start + 1;
            }
            
            // sum이 k 보다 작은 경우 또는 같은 경우
            // 같은 경우라도 다음 경우의 수를 위해 end를 옮길 필요가 있다.
            // k 보다 작은 경우는 일반적으로 값을 증가시키기 위해 end 위치를 옮긴다.
            if (sum <= k) {
                // 기본적으로 k보다 작은 경우 end를 늘려서 값을 크게 해줘야 한다.
                end++;
                // end가 범위 값 안에서 움직이며, 움직일때마다 sum에 값을 더 해준다.
                if (end < sequence.length) {
                    sum += sequence[end];
                }
                // end 값이 범위를 벗어나는 경우 while을 탈출하면서 answer를 응답한다.
            } 
            // 이미 k보다 큰 경우는 
            // 수열을 좁히기 위해 현재 start 위치의 값을 sum에서 빼고, start 위치를 위로 옮긴다.
            else {
                sum -= sequence[start];
                start++;
            }
        }
        
        return answer;
    }
}
