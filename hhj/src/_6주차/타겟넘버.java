package src._6주차;

public class 타겟넘버 {

    /**
     * n개의 정수를 순서를 바꾸지 않고 덧셈, 뺄셈하여 타겟 넘버 생성
     * @param numbers : 숫자가 담긴 배열
     * @param target : 타겟 넘버
     * @return : 방법 수
     */
    public static int solution(int[] numbers,
                               int target){

        return dfs(numbers, target, 0, 0);
    }

    private static int dfs(int[] numbers,
                            int target,
                            int depth,
                            int currentNumber) {

        int count = 0;

        if(depth == numbers.length){
            if(currentNumber == target){
                return 1;
            }
            return 0;
        }

        count += dfs(numbers, target, depth+1, currentNumber+numbers[depth]);
        count += dfs(numbers, target, depth+1, currentNumber-numbers[depth]);

        return count;
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 1, 1, 1, 1};
        int[] arr2 = new int[]{4, 1, 2, 1};

        System.out.println(solution(arr2, 4));
    }
}
