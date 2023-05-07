import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";
    private static final String CHANGE = "Change";

    public String[] solution(String[] record) {
        List<Node> 기록 = new ArrayList<>();
        Map<String, String> 닉네임 = new HashMap<>();

        for (String s : record) {
            String[] strs = s.split(" ");
            String command = strs[0];
            String uid = strs[1];

            switch (command) {
                case ENTER:
                    String nick = strs[2];
                    기록.add(new Node(uid, Command.ENTER));
                    닉네임.put(uid, nick);
                    break;
                case LEAVE:
                    기록.add(new Node(uid, Command.LEAVE));
                    break;
                case CHANGE:
                    nick = strs[2];
                    닉네임.put(uid, nick);
                    break;
            }
        }

        return 기록.stream().map(node -> String.format(node.command.getMessage(), 닉네임.get(node.uid)))
                 .toArray(String[]::new);
    }

    private static class Node {
        private String uid;
        private Command command;

        public Node(String uid, Command command) {
            this.uid = uid;
            this.command = command;
        }
    }

    private enum Command {
        ENTER("%s님이 들어왔습니다."),
        LEAVE("%s님이 나갔습니다.");
        private String command;

        Command(String command) {
            this.command = command;
        }

        public boolean isMatch(Command command) {
            return this.equals(command);
        }

        public String getMessage() {
            return command;
        }
    }
}
