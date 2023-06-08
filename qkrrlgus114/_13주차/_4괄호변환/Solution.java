class Solution {
    public String solution(String p) {
        if(p.equals("")){ // p가 빈 문자열이면 p 그대로 반환
            return p;
        }
        // p를 w랑 u로 분리함
        int temp = 0;
        int index = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '(') temp++;
            else if(p.charAt(i) == ')') temp--;
            if(i!=0&&temp==0){
                index = i; // 현재 인덱스 저장
                break;
            }
        }
        // u,v 뽑아냄
        String u = p.substring(0, index+1);
        String v = p.substring(index+1, p.length());

        if(check(u)){ // u가 올바른 문자열이면 v 1단계부터
            return u + solution(v);
        }else{ // 아니라면 아래처럼
            return "("+solution(v)+")"+reverse(u);
        }
    }

    public static boolean check(String u){
        int temp = 0;
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                temp++;
            }else if(u.charAt(i) == ')'){
                temp--;
            }
            if(temp<0) return false;
        }
        return true;
    }

    public static String reverse(String u){
        String temp = "";
        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i) == '('){
                temp+=")";
            }else{
                temp+="(";
            }
        }
        return temp;
    }
}