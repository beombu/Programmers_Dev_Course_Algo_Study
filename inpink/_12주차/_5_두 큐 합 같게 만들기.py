from collections import deque

def solution(queue1, queue2):
    
    sum1=sum(queue1)
    sum2=sum(queue2)
    half=(sum1+sum2)//2
    n=len(queue1)+len(queue2)
    
    #절대 만들 수 없는 경우1. 홀수
    if (sum1+sum2)%2!=0:
        return -1
    
    answer = 0
    q1=deque(queue1)
    q2=deque(queue2)

    
    while True:
        if sum1==sum2 : break
          
        if sum1<sum2: #q2가 더 크면
            pop=q2.popleft()
            q1.append(pop)
            sum2-=pop
            sum1+=pop
        else:
            pop=q1.popleft()
            q2.append(pop)
            sum1-=pop
            sum2+=pop
            
        answer+=1
        
        #A = [3, 3, 3, 3], B = [3, 3, 21, 3]의 경우를 생각해보자
        #결국, len(A)+len(B)의 2배정도 줘놓으면
        #하나만 남기고 B->A로 이동했다가 A의 하나만 남기고 A->B로 이동하는 경우도 커버한다.
        #이동을 넉넉하게 2*n회까지 할 수 있도록 해준 것이다
        if answer>2*n: 
            answer=-1
            break

    return answer
