def solution(elements):
    ans = set()
    n=len(elements)
    for i in elements:
        ans.add(i)
        
    ans.add(sum(elements))
    
    dp=[[0 for i in range(n)] for i in range(n+1)]
    dp[1]=elements
    
    for i in range(2,n):
        for j in range(n):
            dp[i][j]=dp[i-1][j]+dp[i-1][(j+1)%n]-dp[i-2][(j+1)%n]
            ans.add(dp[i][j])
    return len(ans)
