def gcdCal(w,h):
    a,b = max(w,h),min(w,h)
    while(True):
        r= a%b
        if r == 0:
            return b
        a = b
        b = r
        

def solution(w,h):
    gcd = gcdCal(w,h) #최대공약수 계산
    return w*h-(w+h-gcd)
