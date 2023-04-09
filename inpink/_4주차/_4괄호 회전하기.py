from collections import deque

def solution(s):
    answer = 0
    n=len(s)
    deq=deque(s)
    for i in range(n):
        stack=[]     
        #print(deq)
        for j in range(n):
            괄호=deq[j]
            if len(stack)==0:
                stack.append(deq[j])
            else:
                if stack[-1] == '[' and deq[j] == ']':
                    stack.pop()
                elif stack[-1] == '{' and deq[j] == '}':
                    stack.pop()
                elif stack[-1] == '(' and deq[j] == ')':
                    stack.pop()
                else:
                    stack.append(deq[j])
        #print(stack)
        if len(stack)==0:
            answer+=1
        deq.rotate(-1) 
        #print(deq)
    
    return answer
