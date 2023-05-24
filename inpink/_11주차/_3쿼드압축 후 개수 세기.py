def solution(arr):
    answer = [0,0]
    
    #재귀로 해결
    compression(arr,answer,0,0,len(arr))
    
    return answer


def compression(arr, answer, x,y,n):
    for i in range(x, x + n):
        for j in range(y, y + n):
            if arr[i][j] != arr[x][y]:
                n//=2
                compression(arr,answer, x, y, n)
                compression(arr,answer, x, y + n, n)
                compression(arr,answer, x+n, y, n)
                compression(arr,answer, x+n, y+n, n)
                return
    #모든걸 다 쪼갠 끝에서 실행됨
    answer[arr[x][y]] += 1 
