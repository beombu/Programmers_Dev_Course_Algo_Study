public class _2개_이하로_다른_비트 {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        for (int i = 0; i < len; i++) {
            answer[i] = getBigChgBit(numbers[i]);
        }
        return answer;
    }

    public long getBigChgBit(long num) {
        if (num % 2 == 0 || num == 1) return num + 1;

        String binary = Long.toBinaryString(num);
        StringBuilder sb = new StringBuilder(binary);

        if (sb.indexOf("0") < 0) {
            sb.insert(0, '0');
        }

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                if (i != binary.length() - 1) {
                    sb.setCharAt(i + 1, '0');
                }
                break;
            }
        }
        return Long.valueOf(sb.toString(), 2);
    }
}
