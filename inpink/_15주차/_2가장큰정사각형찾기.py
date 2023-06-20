def solution(board):
    answer = board[0][0] # 1x1인 경우 대비 
    
    #dp문제
    n=len(board)
    m=len(board[0])
    for i in range(1,n):
        for j in range(1, m):
            if board[i][j] == 1:
                board[i][j] = 1 + min(board[i-1][j-1], board[i-1][j], board[i][j-1]) #점화식
                answer = max(answer, board[i][j])

    return answer*answer
