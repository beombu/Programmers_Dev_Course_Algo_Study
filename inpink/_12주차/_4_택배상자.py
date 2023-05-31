def solution(order):
    answer = 0
    n=len(order)
    
    #스택을 이용하는 문제 
    subStack=[]
    idx=1 
    
    while True:
        if idx==n+1:
            break
        subStack.append(idx)
        while True:
            if len(subStack)==0: break
            if subStack[-1]!=order[answer]:
                break
                
            answer+=1
            subStack.pop()
        idx+=1             
    return answer
