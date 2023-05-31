def solution(n):
    ans=''
    while True:
        if n==0:
            break
    
        t = n % 3

        if t==0:
            t = 4
            n -= 1

        ans+=str(t)
        n //= 3
    return ans[::-1]
