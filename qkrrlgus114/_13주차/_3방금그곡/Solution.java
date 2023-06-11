class Solution {
    public String solution(String m, String[] musicinfos) {
        m = changeMelody(m); // #이 붙은 음을 다른 문자로 치환
        int maxTime = Integer.MIN_VALUE; // 제일 긴 재생시간
        int firstInfo = Integer.MAX_VALUE; // 가장 빠른 곡 정보
        for(int i=0; i<musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            int start = Integer.parseInt(info[0].substring(0,2))*60 + Integer.parseInt(info[0].substring(3,5));
            int end = Integer.parseInt(info[1].substring(0,2))*60 + Integer.parseInt(info[1].substring(3,5));
            int playTime = end - start;
            info[3] = changeMelody(info[3]); // #이 붙은 음을 다른 문자로 치환

            if(checkMusic(m, info[3], playTime)){ // 포함이 돼 있으면
                if(maxTime<playTime){ // 재생시간이 길면
                    firstInfo = i;
                    maxTime = playTime;
                }else if(maxTime == playTime && firstInfo > i){
                    firstInfo = i;
                }
            }
        }

        if(maxTime == Integer.MIN_VALUE){
            return "(None)";
        }else{
            String[] result = musicinfos[firstInfo].split(",");
            return result[2];
        }
    }

    public static String changeMelody(String str) {
        str = str.replaceAll("C#", "P");
        str = str.replaceAll("D#", "O");
        str = str.replaceAll("F#", "I");
        str = str.replaceAll("G#", "U");
        str = str.replaceAll("A#", "Y");

        return str;
    }

    public static boolean checkMusic(String m, String info, int playTime){
        StringBuilder sb = new StringBuilder();
        int len = info.length();
        if(len>=playTime){ // 만약에 len보다 재생시간이 짧으면
            for(int i=0; i<playTime; i++){
                sb.append(info.charAt(i));
            }
        }else{ // 만약에 len보다 재생시간이 길면
            int temp = 0;
            for(int i=0; i<playTime; i++){
                if(temp == len) temp=0;
                sb.append(info.charAt(temp++));
            }
        }
        if(sb.toString().contains(m)) return true;
        return false;
    }
}