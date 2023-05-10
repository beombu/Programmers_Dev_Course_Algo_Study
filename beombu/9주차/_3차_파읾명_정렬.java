import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _3차_파읾명_정렬 {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();

        for (String str : files) {
            list.add(new File(str));
        }

        String[] answer = new String[files.length];
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getFile();
        }

        return answer;
    }

    class File implements Comparable<File> {
        String head = "";
        String number = "";
        String tail = "";

        public String getFile() {
            return head + number + tail;
        }

        File(String str) {
            int idx = 0;
            while (true) {
                if (str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
                    break;
                }
                idx++;
            }
            this.head = str.substring(0, idx);

            String tmp = "";
            while (true) {
                tmp += str.charAt(idx);
                idx++;
                if (idx >= str.length() || str.charAt(idx) < '0' || str.charAt(idx) > '9') {
                    break;
                }
            }
            this.number = tmp;

            if (idx < str.length()) {
                this.tail = str.substring(idx);
            }
        }

        @Override
        public int compareTo(File o) {
            if (!head.equalsIgnoreCase(o.head)) {
                return head.compareToIgnoreCase(o.head);
            }

            return Integer.compare(Integer.parseInt(number), Integer.parseInt(o.number));

//            String head1 = this.head.toLowerCase();
//            String head2 = o.head.toLowerCase();
//
//            if (head1.equals(head2)) {//head가 같다면
//                int num1 = Integer.parseInt(this.number);
//                int num2 = Integer.parseInt(o.number);
//
//                if (num1 == num2) {//number가 같다면
//                    return 1;
//                } else {
//                    return num1 - num2;
//                }
//            }
//
//            return head1.compareTo(head2);
        }
    }
}
