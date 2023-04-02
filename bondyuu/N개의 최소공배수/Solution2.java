public class Solution2 {
    public int solution(int[] arr) {
        LcmCalulator calculator = new LcmCalulator(arr);

        return calculator.getLCM();
    }


    class LcmCalulator {
        private int[] arr;

        public LcmCalulator(int[] arr) {
            this.arr = arr;
        }
        private int getLCM() {
            int answer = 1;

            int k = 2;
            while (allIsNotOne(arr)) {
                if (containDivisibleOne(arr, k)) {
                    answer = answer * k;
                    continue;
                }

                k++;
            }
            return answer;
        }

        private boolean containDivisibleOne(int[] arr, int k) {
            boolean chk = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]%k==0){
                    arr[i] = arr[i]/k;
                    chk = true;
                }
            }
            return chk;
        }

        private boolean allIsNotOne(int[] arr) {
            for(int item: arr) {
                if (item != 1){
                    return true;
                }
            }
            return false;
        }
    }
}
