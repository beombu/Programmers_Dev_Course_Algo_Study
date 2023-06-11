package _13주차._3차_방금그곡;

public class Solution {
    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String[] musicinfos1 = new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String answer1 = "HELLO";
        String result1 = new Solution().solution(m1, musicinfos1);
        PRINT_RESULT(1, result1, answer1);

        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String answer2 = "FOO";
        String result2 = new Solution().solution(m2, musicinfos2);
        PRINT_RESULT(2, result2, answer2);

        String m3 = "ABC";
        String[] musicinfos3 = new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String answer3 = "WORLD";
        String result3 = new Solution().solution(m3, musicinfos3);
        PRINT_RESULT(3, result3, answer3);
    }

    public static void PRINT_RESULT(int index, String result, String answer) {
        boolean correct = result.equals(answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public String solution(String m, String[] musicinfos) {
        int[] durations = getDurations(musicinfos);
        String[] melodies = getMelodies(musicinfos, durations);
        int max = Integer.MIN_VALUE;
        m = changeMelody(m);
        String answer = "(None)";

        for (int i = 0; i < melodies.length; i++) {
            if (melodies[i].contains(m) && max < durations[i]) {
                max = durations[i];
                answer = getMusicName(musicinfos[i]);
            }
        }
        return answer;
    }

    public String[] getMelodies(String[] musicinfos, int[] durations) {
        String[] result = new String[musicinfos.length];

        for (int i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(",");
            result[i] = getFullMusic(durations[i], changeMelody(split[3]));
        }

        return result;
    }

    private String getFullMusic(int duration, String melody) {
        StringBuilder result = new StringBuilder(melody);
        while (result.length() < duration) {
            result.append(melody);
        }
        result.setLength(duration);
        return result.toString();
    }

    private int[] getDurations(String[] musicinfos) {
        int[] result = new int[musicinfos.length];

        for (int i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(",");
            String[] startSplit = split[0].split(":");
            String[] endSplit = split[1].split(":");

            int hours = Integer.parseInt(endSplit[0]) - Integer.parseInt(startSplit[0]);
            int minutes = Integer.parseInt(endSplit[1]) - Integer.parseInt(startSplit[1]);

            result[i] = hours * 60 + minutes;
        }

        return result;
    }

    private String getMusicName(String musicinfo) {
        return musicinfo.split(",")[2];
    }

    private String changeMelody(String oldMelody) {
        String result = oldMelody;
        result = result.replaceAll("C#", "H");
        result = result.replaceAll("D#", "I");
        result = result.replaceAll("F#", "J");
        result = result.replaceAll("G#", "K");
        result = result.replaceAll("A#", "L");

        return result;
    }
}