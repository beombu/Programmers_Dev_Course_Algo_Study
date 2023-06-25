class Solution {
    public int solution(int storey) {
        // 1. storey 를 string 으로 변환
    	String tmp = Integer.toString(storey);
        
        // 2. storey 각 숫자를 담을 배열 arr 초기화
    	int[] arr = new int[tmp.length()];
    	for(int i=0; i<tmp.length(); i++) {
    		arr[i] = tmp.charAt(i) - '0';
    	}
    	
    	int answer = 0;
    	
        // 3. 숫자의 1의자리부터 접근 시작
    	for(int i=arr.length-1; i>=0; i--) {

            // 3-1. 현재 자리가 5보다 큰 경우, 10으로 만들기 위한 연산 횟수를 더해준다.
    		if(arr[i] > 5) {
    			answer += 10-arr[i];
    			
                // 제일 큰 앞자리 자리수인 경우는 최종적으로 1의 자리가 0이 되어야 하기에 "-" 연산을 한번 해줘야 한다.
    			if(i==0) answer++;
                // 제일 큰 앞자리 자리 수가 아닌 경우, i 기준으로 앞자리 수를 1 증가시켜준다. (올림 했음으로)
    			else arr[i-1]++;
    		}

            // 3-2. 현재 자리가 5이고, 앞자리가 5보다 큰 경우 10으로 만들기 위한 연산 횟수(5)를 더해준다.
            //     단, i가 0인 경우는 앞자리가 없기에 연산을 하지 않는다. (0인 경우를 고려하면 OutOfIndexException 발생-)
    		else if(arr[i]==5 && i>0 && arr[i-1]>=5) {
                // 다음 자리 수 올림
    			arr[i-1]++;
    			answer += 5;
    		}

            // 3-3. (현재 자리가 5인 경우 + 다음 자리가 4 이하인 경우) + (현재 자리가 4 이하인 경우)
            // 현재 위치하고 있는 숫자만큼 내려준다. (올림하지 않는다.)
    		else {
    			answer += arr[i];
    		}

    	}
    	
    	return answer;
    }
}