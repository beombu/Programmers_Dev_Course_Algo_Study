package src._6주차;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

    /**
     * 일정 금액 지불 시 10일 동안 회원 자격 부여
     * 회원 대상으로 매일 1가지 제품 할인 행사
     * 할인 제품 하루 한개 구매 가능.
     * <p>
     * 정현이가 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우 회원가입 진행
     *
     * @param want     : 원하는 제품 배열
     * @param number   : 원하는 제품 수량 배열
     * @param discount : 마트 할인 제품 배열
     * @return : 원하는 제품을 모두 할인받을 수 있는 회원 등록 날짜의 총 일수
     */
    public static int solution(String[] want,
                               int[] number,
                               String[] discount) {

        int answer = 0;

        Map<String, Integer> wantProduct = new HashMap<>();
        Map<String, Integer> discountProduct = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantProduct.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            discountProduct.put(discount[i], discountProduct.getOrDefault(discount[i], 0) + 1);
        }

        for (int i = 10; i < discount.length; i++) {

            answer = isDiscount(discountProduct, wantProduct) ? answer + 1 : answer;

            discountProduct.put(discount[i - 10], discountProduct.get(discount[i - 10]) - 1);

            if (discountProduct.get(discount[i - 10]).equals(0)) {
                discountProduct.remove(discount[i - 10]);
            }

            discountProduct.put(discount[i], discountProduct.getOrDefault(discount[i], 0) + 1);
        }

        answer = isDiscount(discountProduct, wantProduct) ? answer + 1 : answer;

        return answer;
    }

    public static boolean isDiscount(Map<String, Integer> discountProduct,
                                     Map<String, Integer> wantProducts) {

        for (String wantProduct : wantProducts.keySet()) {

            if (!discountProduct.containsKey(wantProduct)) {
                return false;
            }

            if (!discountProduct.get(wantProduct).equals(wantProducts.get(wantProduct))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String[] arr1 = new String[]{"banana", "apple", "rice", "pork", "pot"};

        int[] arr2 = new int[]{3, 2, 2, 2, 1};

        String[] arr3 = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(arr1, arr2, arr3));
    }
}
