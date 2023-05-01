import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class 오픈채팅방 {
    public static final String ENTER_FORMAT = "%s님이 들어왔습니다.";
    public static final String LEAVE_FORMAT = "%s님이 나갔습니다.";

    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, User> map = new LinkedHashMap<>();
        List<Command> commandList = new ArrayList<>();

        for (String str : record) {
            String[] records = str.split(" ");
            String userCommand = records[0];

            if (userCommand.equals("Enter")) {
                String userId = records[1];
                String userNickName = records[2];

                map.put(userId, new User(userNickName));
                commandList.add(new Command(userId, userCommand));

            } else if (userCommand.equals("Leave")) {
                String userId = records[1];

                commandList.add(new Command(userId, userCommand));
            } else if (userCommand.equals("Change")) {
                String userId = records[1];
                String userNickName = records[2];

                map.get(userId).setNickname(userNickName);
            }
        }

        answer = new String[commandList.size()];
        for (int i = 0; i < commandList.size(); i++) {
            String userId = commandList.get(i).getId();
            String command = commandList.get(i).getCommand();

            if (command.equals("Enter")) {
                answer[i] = String.format(ENTER_FORMAT, map.get(userId).getNickname());
            } else if (command.equals("Leave")) {
                answer[i] = String.format(LEAVE_FORMAT, map.get(userId).getNickname());
            }
        }

        return answer;
    }
}

class User {
    private String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

class Command {
    private String id;
    private String command;

    public Command(String id, String command) {
        this.id = id;
        this.command = command;
    }

    public String getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
