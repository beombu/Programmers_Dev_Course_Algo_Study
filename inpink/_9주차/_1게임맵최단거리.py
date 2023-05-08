from collections import deque

def solution(maps):
    ans = 0
    n=len(maps)
    m=len(maps[0])
    
    #기본 bfs문제 
    방향=[[-1,0],[1,0],[0,-1],[0,1]] #상하좌우
    visited=[[ 0 for i in range(m) ] for i in range(n)]
    dq=deque([[0,0,1]]) #start x,y,count (시작점도 세므로 1로 시작 )
    visited[0][0]=1 #시작점 방문체크
    
    while True:
        if len(dq)==0: #도착하기 전에 큐가 텅 비어버리면 갈수없다는 뜻 
            ans=-1
            break
            
        curX,curY,count=dq.popleft()
        #print(curX,curY,count)
        
        for i in range(4):
            x방향,y방향=방향[i]
            moveX=curX+x방향
            moveY=curY+y방향
            
            #도착점 방문 가능하면, 다른 데큐들 다 무시하고 바로 종료 가능(선입선출-가장 빠른 것이니까)
            if curX==n-1 and curY==m-1: 
                ans=count
                return ans
            
             #상하좌우 벽이거나, 0벽이거나, 이미 더 빠른 count로 방문했거나
            if (moveX<0 or moveX>n-1  or moveY<0 or moveY>m-1) or (maps[moveX][moveY]==0) or (visited[moveX][moveY]==1):
                continue
            
            #그렇지 않은 경우 후보지로 등록 가능
            visited[moveX][moveY]=1
            dq.append([moveX,moveY,count+1])
       
    return ans
    
