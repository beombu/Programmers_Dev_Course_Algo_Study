package soochangoforit._13주차._방금그곡;

import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxDuration = 0;
        
        // 찾고자 하는 음에서 #이 붙은 음을 소문자로 치환
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
        
        for(String musicinfo : musicinfos){
            String[] info = musicinfo.split(",");
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            
            // 총 재생 시간 (분 단위)
            int duration = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            
            // if 문에서는 m이 재생된 전체 음에 없으면 maxDuration은 여전히 0으로 초기화 되어있다.
            // 만약, if 문 안에서 m을 찾았다면 재생된 시간이 긴 음악이 정답으로 표기된다.
            // 만약 앞서 재생된 길이와 같은 길이의 음악이 있고 내부적으로 m을 찾아서 정답의 후보가 되더라도 
            // 최종적으로는 맨 처음으로 찾은 음악이 정답이 되는 요구사항 이기에
            // 앞서 0 이 아닌 duration이 존재한다면 , 값을 갱신할 수 있는 조건은 오로지 duration이 maxDuration보다 클 때이다.
            // duration이 앞전과 같고, 내부적으로 m을 찾았다 하더라도 먼저 찾은 음악이 정답이 되어야 하기에 무조건 큰 경우에만 정답을 갱신한다.
            if(duration > maxDuration) {
                 // 입력으로 들어온 음을 #이 붙은 음을 소문자로 치환 (melody는 라디오에서 재생된 음을 의미)
                String melody = info[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
            
                // 총 재생된 시간에 따라서, 전체 재생된 음을 저장
                StringBuilder play = new StringBuilder();
                for(int i = 0; i < duration; i++){
                    play.append(melody.charAt(i % melody.length()));
                }
            
                // 찾고자 하는 m 이 전체 재생된 음에 포함되어 있다면, maxDuration을 갱신하고, answer를 갱신
                if(play.toString().contains(m)){
                    maxDuration = duration;
                    answer = info[2];
                }

                // 찾고자 하는 m이 없다면 기본값 그대로 "(None)"이 된다.
            }
        }
        return answer;
    }
    
}
