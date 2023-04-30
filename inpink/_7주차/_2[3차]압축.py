def solution(msg):
    answer = []
    
    index=26
    d={}
    for i in range(26):
        d[chr(i+65)]=i+1
        
    while True:
        if len(msg)==0:
            break
        tmp=""
        for i in range(len(msg)):
            tmp+=msg[i]
            if tmp not in d:
                index+=1
                d[tmp]=index
                tmp=tmp[:-1]
                answer.append(d[tmp])
                break
        msg=msg[len(tmp):]
        
    #마지막 글자 예외 
    answer.append(d[tmp])
    
    return answer
