def solution(land):
    ans=0
    
    #DP문제 
    #★★모든 land[x][y]에, 현 시점에서 최선의 값을 구해놓는 것★★이므로! ☆그리디 아님!
    for i in range(1,len(land)):
        for j in range(len(land[0])):
            land[i][j] += max(land[i-1][:j] + land[i-1][j+1:])
            
    ans=max(land[-1])
    return ans
