import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringTokenizer st= new StringTokenizer(s);
        
        String[] l= s.split("");
  
        StringBuilder sb= new StringBuilder();
        String before = " ";
        boolean next=false;
        for (int i=0; i<l.length; i++) {
            if (l[i].equals(" ")) { //공백은 그냥 넣어주고
                sb.append(l[i]);
            }
            else { //공백아닌 것중에
                if (before.equals(" ")){ //단어의 첫글자면
                    if (Character.isDigit(l[i].charAt(0))) { //첫글자가 정수면 
                        sb.append(l[i]);
                        next=true;  
                    }
                    else { //첫글자가 문자면
                        sb.append(l[i].toUpperCase());
                    }
                }
                else { //단어의 두번째 글자부터
                    if (next==true) { //숫자 다음글자라 소문자로 해줘야함
                        sb.append(l[i].toLowerCase());
                        next=false;
                    }
                    else{ //특별한것 없어서 다 소문자로 바꿔주면 됨 
                        sb.append(l[i].toLowerCase());
                    }
                }
            }
            before = l[i];
    }
    return sb.toString();     
    }
}