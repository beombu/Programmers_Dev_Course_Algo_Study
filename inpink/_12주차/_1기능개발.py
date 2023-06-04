from collections import deque
import math
def solution(progresses, speeds):
    answer = []
    
    #큐 이용 
    
    #7 3 9
    #7 7 9
    #2 1
    
    #5 10 1 1 20 1
    #5 10 10 10 20 20
    #1 3 2
    q=deque()
    n=len(progresses)
    
    
    for i in range(n):
        fun=progresses[i]
        speed=speeds[i]
        time=math.ceil((100-fun)/speed) #올림 해야함
        q.append(time)
    #print(q)
    
    
    #첫번째거는 넣고 시작
    maxx=q.popleft()
    count=1
    
    for i in range(n-1):
        left=q.popleft()
        if left>maxx:
            answer.append(count)
            count=1
            maxx=left
        else:
            count+=1
    
    if count!=0: #남은 count 처리
        answer.append(count) 
    
    return answer
