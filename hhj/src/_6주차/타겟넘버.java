package src._6주차;


public class 타겟넘버 {

    static int size;
    static int answer = 0;

    /**
     * n개의 정수를 순서를 바꾸지 않고 덧셈, 뺄셈하여 타겟 넘버 생성
     * @param numbers : 숫자가 담긴 배열
     * @param target : 타겟 넘버
     * @return : 방법 수
     */
    public static int solution(int[] numbers,
                               int target){

        size = numbers.length;

        dfs(0, 0, target, numbers);

        return answer;
    }

    private static void dfs(int depth,
                            int sum,
                            int target,
                            int[] numbers){

        if(depth == size){
            if(target == sum){
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum+numbers[depth], target, numbers);
        dfs(depth + 1, sum-numbers[depth], target, numbers);
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 1, 1, 1, 1};
        int[] arr2 = new int[]{4, 1, 2, 1};

        System.out.println(solution(arr2, 4));
    }
}
