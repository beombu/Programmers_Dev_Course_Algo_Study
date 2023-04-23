package src._6주차;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class 전화번호목록 {

    /**
     * 전화번호 중 한 번호가 다른 번호의 접두어인지 확인
     * @param phoneBook : 전화번호를 담은 배열
     * @return : 있으면 false 없으면 true
     */
    public static boolean solution(String[] phoneBook) {

        Arrays.sort(phoneBook, Comparator.comparingInt(String::length).reversed());

        Set<String> stringSet = Arrays.stream(phoneBook).collect(Collectors.toSet());

        int minSize = phoneBook[phoneBook.length-1].length();

        for(int i=0; i<phoneBook.length; i++){

            for(int j=minSize-1; j<phoneBook[i].length(); j++){

                if(stringSet.contains(phoneBook[i].substring(0, j))){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String[] arr = new String[]{"119", "97674223", "1195524421"};
        System.out.println(solution(arr));
    }
}
