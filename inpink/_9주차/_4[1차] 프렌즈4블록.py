def solution(m, n, board): #m열 n행 
    answer = 0

    board=dataClean(m, n, board)

    while True:
        count=fourBlock(m,n,board)
        if count==0:
            break
        answer+=count

        push(m,n,board)#밀기
          
    #print(board,answer)
    return answer


def dataClean(m,n,board):
    tmp=[ [ '' for i in range(n)] for i in range(m) ]
    for i in range(m):
        for j in range(n):
            tmp[i][j]=board[i][j]
    return tmp
    
def fourBlock(m,n,board):
    count=0
    dirr=[[0,1],[1,0],[1,1],[0,0]] #오른, 아래, 오른아래, 현재
    erase=[]
    for i in range(m-1): #☆오른쪽 맨끝줄, 아래맨끝줄은 검사할 필요 X
        for j in range(n-1):
            success=True
            tmp=board[i][j]
            for k in range(3):
                dirX,dirY=dirr[k]
                moveX=i+dirX
                moveY=j+dirY
                if not (board[moveX][moveY]==tmp):
                    success=False
                    break
            if success==True:
                #여기서 바로 지워주면, 2x2 이상으로 연속된 부분을 탐지못함. 담아놓고 차후 한번에 처리
                for p in range(4):
                    dirX,dirY=dirr[p]
                    moveX=i+dirX
                    moveY=j+dirY
                    erase.append([moveX,moveY])
    for x,y in erase:
        if board[x][y]!='':
            board[x][y]=''
            count+=1
    return count                

def push(m,n,board):
    #각 자리에 떨어질 수 있는 값이 있는지 검사
    for i in range(m-1,0,-1): #맨아래~둘째줄까지만 검사해도됨(첫째줄엔 담아줄 수 있는 더 상위의 값이 없기 때문) 
        for j in range(n):
            if board[i][j]=='':
               findTop(i,j,board) 
            
def findTop(i,j,board):
    for h in range(i-1,-1,-1):
        if board[h][j]!='':
            board[i][j]=board[h][j]
            board[h][j]=''
            break
            
