import java.util.*;

class Solution {
    // expression에 담긴 숫자 목록
    ArrayList<Long> nums = new ArrayList<>();
    // expression에 담긴 연산자 목록
    ArrayList<Character> cals = new ArrayList<>();
    
    // 순열을 이룰 수 있는 연산자 종료
    char[] calCandidate = {'+', '*', '-'};
    boolean[] calVisit = new boolean[3];
    char[] realCals = new char[3];
    
    // 정답
    long answer = 0;
    
    public long solution(String expression) {

        // 1. expression에 담긴 숫자와 연산자를 list에 담기
        String tempNum = "";
        for(int i = 0; i < expression.length(); i++) {
            // 1-1. 숫자라면 tempNum에 계속해서 값을 넣어준다 (2자리, 3자리도 숫자로 가능하기에 -> 바로 nums에 넣지 않는다.)
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                tempNum += expression.charAt(i);
            }
            // 1-2. 연산자를 만나면 지금까지 tempNum에 저장했던 문자열을 nums에 넣어준다.
            // 연산자를 cals에 넣어준다.
            else {
                nums.add(Long.parseLong(tempNum));
                // 다음 숫자를 받기 위해 초기화
                tempNum = "";
                cals.add(expression.charAt(i));
            }
        }
        // 1-3. for문이 끝나면 맨 마지막 숫자가 tempNum에 담겨 있다. nums list에 넣어준다.
        nums.add(Long.parseLong(tempNum));
        
        // 2. 연산자 조합을 위한 순열 만들기 (내부적으로 조합을 만드면 그 조합 우선순위에 맞는 최대값 answer 할당)
        perm(0,3);
    
        return answer;
    }
    
    // 2-1. 연산자들의 후보를 통해서 순열 배열을 만들고, 우선 순위에 맞는 연산을 통해 결과값을 갱신한다.
    public void perm(int count, int target) {
        // 만들어진 연산자 조합 배열의 길이 (count) 가 만들고자 하는 순열의 길이 (target)과 같다면
        if(count == target) {
            solve();
            return;
        }
        else {
            // 총 3개의 연산자를 통해서 조합을 만들고자 한다.
            for(int i = 0; i < 3; i++) {
                // 방문하지 않은 연산자에 한해서 만들고자 한다.
                if (calVisit[i] == false) {
                    calVisit[i] = true;
                    // 연산자 후보에서 실제 우선순위 연산자로 사용할 배열에 값 할당
                    realCals[count] = calCandidate[i];
                    perm(count + 1, target);
                    calVisit[i] = false;
                }
            }
        }
    }
    
    
    // 3. realCals에 있는 우선순위 연산자에 따라 최대값을 계산하여 갱신한다.
    public void solve() {
        // 3-1. nums 와 cals 리스트를 복제하여 계산한다. (원본 리스트는 다른 우선순위 계산에서도 사용해야 함으로 고려 X)
        ArrayList<Long> cNums = new ArrayList<>(nums);
        ArrayList<Character> cCals = new ArrayList<>(cals);
        
        // 3-2. 우선 순위에 맞게 연산자 순회
        for(int i = 0; i < realCals.length; i++) {
            // expression에 나온 연산자 순서에서
            for(int k = 0; k < cCals.size(); k++) {
                // 우선 순위와 일치하는 연산자가 나왔다면
                if (realCals[i] == cCals.get(k)) {
                    // k index에 위치하는 숫자 제거하면 뒤에 있는 숫자가 다시 k로 앞으로 댕겨온다.
                    // 따라서, k index로 remove를 2번 호출한다.
                    Long result = cal(cNums.remove(k), cNums.remove(k), cCals.get(k));
                    // k index 위치에 연산하여 나온 값을 다시 넣어준다.
                    cNums.add(k, result);
                    // k index에 위치한 연산자는 사용했기에 cCals 리스트에서 제거한다.
                    cCals.remove(k);
                    // (중요) k 값을 하나 낮춰야 한다. 왜냐하면 cNums에 k index에 새로운 값이 들어왔고
                    // k index에 원래 k 위치 뒤에 있던 연산자가 앞으로 당겨왔기 때문이다. 
                    // 뒤에서 앞으로 당겨진 연산자도 고려하기 위해선 반드시 필요하다.
                    // 만약 k-- 를 하지 않는다면, 뒤에서 앞으로 당겨온 해당 연산자를 for문에서 건너뛰고 수행한다.
                    k--;
                }
            }
        }
        // 최대 결과값을 갱신합니다. cNums에는 최종적으로 하나의 숫자만 남아있다.
        answer = Math.max(answer, Math.abs(cNums.get(0)));
        
    }
    
    
    // 4. cal 함수 정의
    public Long cal(Long num1, Long num2, char op) {
        long num = 0;
        switch(op) {
            case '+':
                num = num1 + num2;
                break;
            case '-':
                num = num1 - num2;
                break;
            case '*':
                num = num1 * num2;
                break;
        }
        return num;
    }
    
}