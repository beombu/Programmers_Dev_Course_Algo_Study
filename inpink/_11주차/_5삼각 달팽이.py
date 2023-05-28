def solution(n):
    
    #n=1000 => n^2으로 해결하라
    
    answer = [[0 for j in range(i)] for i in range(1,n+1)] #데이터 구조 똑같게 
    num=1 #맨 처음 기입되는 숫자는 1
    x, y = -1, 0 #시작 좌표 -1,0으로 해야 0,0부터 기입하기 시작함 
    
    #4+3+2+1
    #5+4+3+2+1
    #6+5+4+3+2+1 각 숫자만큼 같은 방향으로 이동한다
    #하->우->상 반복
    for i in range(n): 
        for j in range(i, n):
            if i % 3 == 0: #하
                x += 1 
            elif i % 3 == 1: #우
                y += 1
            elif i%3==2: #상
                x -= 1
                y -= 1
            
            #print(i,j,x,y,num)
            answer[x][y] = num #x,y 좌표를 이용하여 answer에 기입
            num += 1 #달팽이가 움직일때마다 점수+=1

    
    return  sum(answer, []) #2차원 리스트 1차원으로 합치기
