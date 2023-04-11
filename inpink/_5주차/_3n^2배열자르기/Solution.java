class Solution {
    public int[] solution(int n, long left, long right) {
        int ans[] = new int[(int) (right-left+1)];//☆left와 right의 범위가 10^14까지이나, 담기는 값은 n=10^7까지이므로 int 써도 됨!
		//★배열 크기 선언 시 int형 써줘야 함!! 자바 배열 최대 크기는 int와 같은 4Byte이기 때문이다!!★
		long a,b;
		for (long i=left; i<=right; i++) { //☆여기도 당연히 long 써줘야 함
			a=i/n;
			b=i%n;
			ans[(int) (i-left)]= (a>=b ? (int)a+1 :(int) b+1);
		}
		return ans;
    }
}
