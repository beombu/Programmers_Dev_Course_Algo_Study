from collections import deque
def solution(N, road, K):
    answer = 0
    
    arr= [ [] for i in range(N+1)]
    ans=[ False for i in range(N+1)]
    ans[1]=True # 자기 자신은 무조건 방문 가능
    visited=  [5000001 for i in range(N+1) ] 
    
    for a,b,w in road:
        arr[a].append([b,w])
        arr[b].append([a,w])
        
    for i in arr:
        i.sort()
        
    #print(arr)
    
    
    #bfs 사용
    q=deque()
    
    #1번째 이웃들 넣고 시작
    for next,w in arr[1]:
        q.append([next,w])
        visited[next]=w

        
    while True:
        if len(q)==0:
            break
        
        next,w=q.popleft()
        
        if w<=K:
            ans[next]=True
            
            for next2,w2 in arr[next]:
                if w+w2<=K and visited[next2]>w+w2:
                    q.append([next2,w+w2])
                    visited[next2]=w+w2
                
    #print(ans)
    
    for i in ans:
        if i==True:
            answer+=1
            
    return answer
