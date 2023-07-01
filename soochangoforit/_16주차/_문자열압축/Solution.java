

class Solution {
    public int solution(String s) {
        
        // 초기 답변을 문자열의 길이로 설정합니다.
        int answer = s.length();
        
        // 모든 가능한 패턴 크기를 고려합니다 (문자열의 절반 길이로).
				// 만약 5글자라면 2자리까지만 패턴으로 고려하면 된다. 패턴 3자리 부터는 의미 없다.
        for(int pattern_size = 1; pattern_size <= s.length() / 2; pattern_size++) {
            String temp_answer_string = "";
            
            // 현재 패턴의 길이만큼 잘라 표준 패턴을 찾습니다.
            String cur_pattern = s.substring(0, pattern_size);
            int count = 1;
            
            // 패턴 이후 문자열을 시작하여 비교합니다.
            for(int k = pattern_size; k < s.length(); k += pattern_size) {
                String sub;
                
                // 잘라야 할 최종 인덱스가 s의 마지막 위치에서 길이보다 작거나 같으면 끝까지 자를 수 있습니다.
                if (k + pattern_size <= s.length()) {
                    sub = s.substring(k, k + pattern_size);
                } 
                // 잘라야 할 인덱스의 마지막 위치가 s의 길이보다 크면 마지막 문자열까지만 우선적으로 잘라냅니다.
                else {
                    sub = s.substring(k);
                }
                
                // 만약 표준 패턴과 일치한다면 카운트를 증가시킵니다.
                if (cur_pattern.equals(sub)) {
                    count++;
                } else {
                    // 표준 패턴과 일치하지 않으면, 현재 패턴 카운트와 패턴 문자열을 결합하여 temp_answer에 넣어야 합니다.
                    // 일치하지 않는 sub는 새로운 패턴이 되어야 하므로 카운트는 1로 다시 초기화됩니다.
                    temp_answer_string += (count > 1) ? count + cur_pattern : cur_pattern;
                    cur_pattern = sub;
                    count = 1;
                }
            }

            // 패턴이 끝까지 일치하고 카운트 값만 증가하고 temp_anwer_String에 값을 넣을 수 없거나
            // 새롭게 패턴을 추출헸지만 더 이상 비교할 문자열이 없어 count가 1로 남겨진 상태에서 temp에 넣어준다.
            temp_answer_string += (count > 1) ? count + cur_pattern : cur_pattern;

            // 답변을 현재 답변과 압축 문자열의 길이 중 더 작은 값으로 업데이트합니다.
            answer = Math.min(answer, temp_answer_string.length());
        }
        
        // 최종 답변을 반환합니다.
        return answer;
    }
}