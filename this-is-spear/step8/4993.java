class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String st : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < st.length(); i++) {
                char c = st.charAt(i);
                if (condition(c, skill)) {
                    sb.append(c);
                }
            }
            if (ensure(sb.toString(), skill)) {
                answer += 1;
            }
        }

        return answer;
    }

    private boolean condition(char c, String skill) {
        for (int i = 0; i < skill.length(); i++) {
            if (skill.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    private boolean ensure(String result, String skill) {
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != skill.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
