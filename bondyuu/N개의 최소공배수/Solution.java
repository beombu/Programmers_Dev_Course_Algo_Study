import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;

        int k = 2;
        boolean chk = false;
        while (true) {
            if (allOne(arr)) {
                break;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i]%k==0){
                    arr[i] = arr[i]/k;
                    chk = true;
                }
            }

            if(chk){
                answer = answer * k;
                chk = false;
                k = 2;
                continue;
            }

            k++;
        }

        return answer;
    }

    public boolean allOne(int[] arr) {
        for(int item: arr) {
            if (item != 1){
                return false;
            }
        }
        return true;
    }
}