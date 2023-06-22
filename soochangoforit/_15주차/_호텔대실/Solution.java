import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        // 시작 시간 기점으로 오름차순 정렬
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int startTime1 = timeToMinutes(o1[0]);
                int startTime2 = timeToMinutes(o2[0]);
                return startTime1 - startTime2;
            }
        });

        // 호텔 객실의 이용 종료 시간을 저장하는 우선순위 큐 (오름 차순)
        PriorityQueue<Integer> endTimeList = new PriorityQueue<>();

        int roomCount = 0;

        // 예약을 모두 순회 (이미 오름차순 정렬 됨)
        for(String[] timeTable : book_time) {
            // 만약 예약이 없다면, 새로운 객실을 추가
            if (endTimeList.isEmpty()) {
                roomCount++;
                endTimeList.add(timeToMinutes(timeTable[1]));
            } 
            // 누군가 호텔을 이용중이라면
            else {
                // 새롭게 시작하고자 하는 호텔 이용 시작 시간
                int startTime = timeToMinutes(timeTable[0]);

                // 현재 객실 중 가장 빨리 끝나는 시간
                int earliestEndTime = endTimeList.peek();

                // 만약 현재 객실 중 가장 빨리 끝나는 시간보다 10분 뒤에 시작한다면
                if (startTime - earliestEndTime >= 10) {
                    // 빨리 끝나는 시간을 뽑아내고 새로운 객실을 추가
                    endTimeList.poll();
                } else {
                    // 다른 객실을 이용해야 하기에 객실을 추가
                    roomCount++;
                }
                endTimeList.add(timeToMinutes(timeTable[1]));
            }
        }

        return roomCount;
    }

    // 시간을 분으로 변환
    private int timeToMinutes(String timeStr) {
        String[] timeParts = timeStr.split(":");
        return Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
    }
}
