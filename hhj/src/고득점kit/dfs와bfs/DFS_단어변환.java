package src.고득점kit.dfs와bfs;

public class DFS_단어변환 {

    static int answer = Integer.MAX_VALUE;
    static boolean[] visit;

    /**
     * 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정
     * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
     * 2. words에 있는 단어로만 변환할 수 있습니다.
     *
     * @param begin  : 시작 단어
     * @param target : 변경할 단어
     * @param words  : 단어의 집합
     * @return : 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지
     */
    public static int solution(String begin,
                        String target,
                        String[] words) {

        visit = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private static void dfs(String begin,
                     String target,
                     String[] words,
                     int depth){

        if(answer < depth){
            return;
        }

        if(begin.equals(target)){
            answer = depth;
            return;
        }

        for(int i=0; i<words.length; i++){

            if(visit[i]) continue;

            int check = 0;

            for(int j=0; j<begin.length(); j++){
                if(words[i].charAt(j) != begin.charAt(j)){
                    check++;
                }
                if(check > 1) break;
            }

            if(check == 1){
                visit[i] = true;
                dfs(words[i], target, words, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution("hit", "cog", arr));
    }
}
