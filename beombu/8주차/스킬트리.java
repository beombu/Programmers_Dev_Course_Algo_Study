import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 스킬트리 {
    public static int count = 0;

    public int solution(String skill, String[] skill_trees) {
        Queue<Character> queue = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        for (Character ch : skill.toCharArray()) {
            queue.add(ch);
            set.add(ch);
        }

        checkStillTree(queue, set, skill_trees);

        return count;
    }

    private void checkStillTree(Queue<Character> queue, HashSet<Character> set, String[] skill_trees) {
        for (int i = 0; i < skill_trees.length; i++) {
            Queue<Character> cloneQueue = new LinkedList<>(queue);
            HashSet<Character> cloneSet = new HashSet<>(set);

            for (Character ch : skill_trees[i].toCharArray()) {
                //필수로 배워야하는 스킬에 존재하는 경우
                if (cloneSet.contains(ch)) {
                    //순서가 맞다면
                    if (cloneQueue.peek().equals(ch)) {
                        cloneSet.remove(ch);
                        cloneQueue.poll();

                        if (cloneQueue.isEmpty()) {
                            count++;
                            System.out.println(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }

                if (skill_trees[i].charAt(skill_trees[i].length() - 1) == ch) {
                    count++;
                }
            }
        }
    }
}
