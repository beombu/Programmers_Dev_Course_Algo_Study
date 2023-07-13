def solution(n):
    chk=[0]*12 #세로 열에 들어 왔는가
    chk2=[0]*27 #좌->우측 대각선
    chk3=[0]*27 #우->좌측 대각선

    ans=[]

    ans2=dfs(0,n,chk,chk2,chk3,ans)
    return len(ans2)

def dfs(x,n,chk,chk2,chk3,ans):
    if (x==n): #n개 다 채워지면
        ans.append(1)
        #print(ans)
        return ans

    for i in range(n):
        if chk[i] or chk2[i+x] or chk3[i-x + n-1]:
            continue
        chk[i]=1
        chk2[i+x]=1
        chk3[i-x + n-1]=1
        dfs(x+1,n,chk,chk2,chk3,ans)
        chk[i]=0
        chk2[i+x]=0
        chk3[i-x + n-1]=0
    return ans
