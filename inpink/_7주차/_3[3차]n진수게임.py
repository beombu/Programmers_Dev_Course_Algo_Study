def solution(n, t, m, p):
    answer = ''
    
    string='0'
    for i in range(t*m):
        string+=k진수변환(i,n)
    for i in range(p-1,t*m,m):
        answer+=string[i]
    return answer



def k진수변환(n,k):
    nums="0123456789ABCDEF"
    trans=""
    
    while True:
        if n==0:
            break
        trans+=(nums[n%k])
        n//=k
    return trans[::-1] #문자열 뒤집기
