package _8주차.방문길이;

import java.util.Arrays;

class Solution {
    public static final int MAP_LENGTH = 11;
    public static final int UP_DIRECTION = 0;
    public static final int LEFT_DIRECTION = 1;
    public static final int RIGHT_DIRECTION = 2;
    public static final int DOWN_DIRECTION = 3;

    public static void main(String[] args) {
        String dirs1 = "ULURRDLLU";
        int answer1 = 7;
        int result1 = new Solution().solution(dirs1);
        PRINT_RESULT(1, result1, answer1);

        String dirs2 = "LULLLLLLU";
        int answer2 = 7;
        int result2 = new Solution().solution(dirs2);
        PRINT_RESULT(2, result2, answer2);
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

    public int solution(String dirs) {
        PathTracker pathTracker = new PathTracker();
        Arrays.stream(dirs.split("")).forEach(pathTracker::move);
        return pathTracker.count;
    }

    public enum MoveDirection {
        U(UP_DIRECTION, DOWN_DIRECTION, new int[]{0, 1}),
        D(DOWN_DIRECTION, UP_DIRECTION, new int[]{0, -1}),
        L(LEFT_DIRECTION, RIGHT_DIRECTION, new int[]{-1, 0}),
        R(RIGHT_DIRECTION, LEFT_DIRECTION, new int[]{1, 0});

        final int forward;
        final int opposite;
        final int[] offset;

        MoveDirection(int forward, int opposite, int[] offset) {
            this.forward = forward;
            this.opposite = opposite;
            this.offset = offset;
        }
    }

    public class PathTracker {
        private final boolean[][][] map;
        private int currentX;
        private int currentY;
        private int count;

        public PathTracker() {
            this.map = new boolean[MAP_LENGTH][MAP_LENGTH][4];
            this.currentX = 5;
            this.currentY = 5;
            this.count = 0;
        }

        public void move(String move) {
            MoveDirection moveDirection = MoveDirection.valueOf(move);
            int newX = currentX + moveDirection.offset[0];
            int newY = currentY + moveDirection.offset[1];

            if (!isValid(newX, newY)) {
                return;
            }

            if (!map[currentX][currentY][moveDirection.forward]) {
                count++;
            }
            map[currentX][currentY][moveDirection.forward] = true;
            map[newX][newY][moveDirection.opposite] = true;

            currentX = newX;
            currentY = newY;
        }

        private boolean isValid(int x, int y) {
            return x >= 0 && x < MAP_LENGTH && y >= 0 && y < MAP_LENGTH;
        }
    }
}