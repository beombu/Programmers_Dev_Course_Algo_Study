package src._8주차;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

    /**
     * [닉네임]님이 들어왔습니다.
     * [닉네임]님이 나갔습니다.
     * <p>
     * 닉네임 변경
     * - 채팅방을 나간 후 새로운 닉네임으로 들어오기
     * - 채팅방에서 닉네임 변경하기
     * - 닉네임 변경시 기존 메시지 닉네임도 모두 변경
     * - 닉네임은 중복을 허용
     *
     * @param record : 채팅방 기록을 담긴 배열
     * @return 채팅방 기록
     */
    public static String[] solution(String[] record) {

        Map<String, User> userMap = new HashMap<>();
        List<Command> commandList = new ArrayList<>();

        for (String str : record) {
            String[] records = str.split(" ");

            String command = records[0];
            String id = records[1];

            if (command.equals("Enter")) {
                String name = records[2];
                userMap.put(id, new User(name));
                commandList.add(new Command(id, command));
            } else if (command.equals("Leave")) {
                commandList.add(new Command(id, command));
            } else if (command.equals("Change")) {
                String changeName = records[2];
                userMap.get(id).setName(changeName);
            }
        }

        int index = 0;
        String[] answer = new String[commandList.size()];

        for (Command command : commandList) {
            if (command.command.equals("Enter")) {
                answer[index++] = userMap.get(command.id).name + "님이 들어왔습니다.";
            } else if (command.command.equals("Leave")) {
                answer[index++] = userMap.get(command.id).name + "님이 나갔습니다.";
            }
        }

        return answer;
    }

    private static class User {

        String name;

        public User(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class Command {

        String id;

        String command;

        public Command(String id,
                       String command) {
            this.id = id;
            this.command = command;
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[]{
                "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"
        };

        String[] answer = solution(arr);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
