def solution(dirs): 
    #상하좌우  x,y,자릿수,반대방향
    방향={'U':[0,1,3,2],'D':[0,-1,2,3],'L':[-1,0,1,0],'R':[1,0,0,1]}
    
    #2차원 좌표  11x11임
    좌표=[[ 0 for i in range(11) ] for i in range(11)]
    
    #시작좌표
    x=5
    y=5
    ans = 0
    for i in dirs:
        moveX,moveY,n,oppo=방향[i]
        candiX=x+moveX
        candiY=y+moveY
        if candiX<0 or candiX>10 or candiY<0 or candiY>10: #벽인지
            continue
        if not(좌표[x][y] & 1<<n): #이미 간 곳이면 ☆이동은 해야함 카운트를 안셀뿐
            ans+=1
            좌표[x][y]+=1<<n
            좌표[candiX][candiY]+=1<<oppo
            #print(i, x-5,y-5,candiX-5,candiY-5,좌표[x][y],좌표[candiX][candiY])
        x=candiX
        y=candiY
        
    #print(좌표, 방향)
    
    return ans
