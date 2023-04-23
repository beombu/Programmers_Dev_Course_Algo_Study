package src._6주차;

import java.util.ArrayList;
import java.util.List;

public class _1차뉴스클러스터링 {

    /**
     * 유사한 기사를 묶는 기준을 정하기 위해서 논문과 자료를 조사하던 튜브는 "자카드 유사도"라는 방법
     * - 두 집합 A, B 사이의 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의
     *
     * 집합 A = {1, 2, 3}, 집합 B = {2, 3, 4},
     * - 교집합 A ∩ B = {2, 3}, 합집합 A ∪ B = {1, 2, 3, 4}
     * - J(A, B) = 2/4 = 0.5
     *
     * 집합 A와 집합 B가 모두 공집합
     * - 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의
     *
     * 원소의 중복을 허용하는 다중집합에 대해서 확장
     * - 다중집합 A는 원소 "1"을 3개
     * - 다중집합 B는 원소 "1"을 5개
     * - 교집합 A ∩ B는 원소 "1"을 min(3, 5)인 3개
     * - 합집합 A ∪ B는 원소 "1"을 max(3, 5)인 5개
     *
     * 다중집합 A = {1, 1, 2, 2, 3}, 다중집합 B = {1, 2, 2, 4, 5}
     * - 교집합 A ∩ B = {1, 2, 2}, 합집합 A ∪ B = {1, 1, 2, 2, 3, 4, 5}
     * - 자카드 유사도 J(A, B) = 3/7, 약 0.42
     *
     * 자카드 유사도를 문자열 사이의 유사도를 계산하는데 이용
     * - 문자열 "FRANCE"와 "FRENCH"가 주어졌을 때, 이를 두 글자씩 끊어서 다중집합을 만들 수 있다.
     * - 각각 {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}
     * - 교집합은 {FR, NC}, 합집합은 {FR, RA, AN, NC, CE, RE, EN, CH}
     * - 두 문자열 사이의 자카드 유사도 J("FRANCE", "FRENCH") = 2/8 = 0.25
     *
     * 조건
     * - 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다
     * - 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
     * - 예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
     * - 다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.
     *
     *@paramstr1: 문자열1
     *@paramstr2: 문자열2
     *@return: 유사도 값은 0에서 1 사이의 실수이므로, 이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력
     */
    public static int solution(String str1,
                               String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i=0; i < str1.length()-1; i++){
            String s = str1.charAt(i) + "" + str1.charAt(i+1);
            if(s.matches("[a-z]+")){
                list1.add(s);
            }
        }

        for(int i=0; i < str2.length()-1; i++){
            String s = str2.charAt(i) + "" + str2.charAt(i+1);
            if(s.matches("[a-z]+")){
                list2.add(s);
            }
        }

        double intersection = 0;
        double union = list1.size() + list2.size();

        for(String s : list1){
            if(list2.contains(s)){
                intersection++;
                list2.remove(s);
            }
        }

        union -= intersection;

        return intersection==0 && union==0 ? 65536 : (int)((intersection/union)*65536);
    }

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
    }
}