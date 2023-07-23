def solution(n):
    if n%2==1:
        return 0

    dp=[0]*(n+1)
    dp[2]=3

    for i in range(4,n+1,2): #dp[4], dp[6], dp[8]...
        dp[i]=dp[i-2]*3+2
        for j in range(2,i-2,2): #i=10일 때는, j=2,4,6
            dp[i]+=dp[j]*2

    return dp[n]%1000000007
