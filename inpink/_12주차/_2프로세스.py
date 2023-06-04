from collections import deque

def solution(priorities, location):
    
    n=len(priorities)
    answer = [ 0 for i in range(n) ] #정답 담을 리스트
    q=deque()
    
    for i in range(n):
        num=priorities[i]
        q.append([num,i])
    #print(q)
    
    priorities.sort(reverse=True)
    prioQ=deque(priorities)
    
    p=1
    while (len(q)!=0):
        leftP,leftI=q.popleft()
        if leftP==prioQ[0]: #maxx값인 경우에만 실행 가능  maxx값은, 정렬된 Q를 이용하여 시간을 효율적으로  관리
            prioQ.popleft()
            answer[leftI]=p
            p+=1
        else: #maxx값이 아닌 경우, ☆큐의 맨 뒤로 보내줘야 함. 단순히 작은 순서대로 뽑는 게 아님.
            q.append([leftP,leftI])
            
    #print(answer)        
    return answer[location]
