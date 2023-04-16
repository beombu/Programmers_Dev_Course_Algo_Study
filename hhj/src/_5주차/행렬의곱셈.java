package src._5주차;

public class 행렬의곱셈 {
    /**
     * @param arr1 : 2차원 행렬1
     * @param arr2 : 2차원 행렬2
     * @return : 행렬1 * 행렬2 결과
     */
    public int[][] solution(int[][] arr1,
                            int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];
        int n = arr1[0].length;

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[0].length; j++){
                for(int k=0; k<n; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}

