from collections import deque
def solution(record):
    answer = []
    dic={}
    dq=deque()
    
    for i in record:
        tmp=i.split(" ")
        동작=tmp[0]
        id=tmp[1]
        if 동작!="Leave":
            nickName=tmp[2]
            dic[id]=nickName
        if 동작!="Change":
            dq.append([동작,id])        
    #print(dic,dq)
    
    for i in range(len(dq)):
        동작,id=dq.popleft()
        if 동작=="Enter":
            answer.append(dic[id]+"님이 들어왔습니다.")
        else:
            answer.append(dic[id]+"님이 나갔습니다.")   
    #print(answer)
    
    return answer
