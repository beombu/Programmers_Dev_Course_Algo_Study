package _8주차.스킬트리.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        String skill1 = "CBD";
        String[] skill_trees1 = new String[]{"BACDE", "CBADF", "AECB", "BDA"};
        int answer1 = 2;
        int result1 = new Solution().solution(skill1, skill_trees1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int solution(String skill, String[] skill_trees) {
        return (int) Arrays.stream(skill_trees).filter(it -> canLearned(skill, it)).count();
    }

    public boolean canLearned(String skill, String skillTree) {
        Set<Character> learned = new HashSet<>();
        List<Character> seq = skill.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        for (int i = 0; i < skillTree.length(); i++) {
            char currentSkill = skillTree.charAt(i);
            if (seq.indexOf(currentSkill) == 0 || !seq.contains(currentSkill)) {
                learned.add(currentSkill);
                continue;
            }

            char leadingSkill = seq.get(seq.indexOf(currentSkill) - 1);
            if (learned.contains(leadingSkill)) {
                learned.add(currentSkill);
                continue;
            }

            return false;
        }

        return true;
    }

}