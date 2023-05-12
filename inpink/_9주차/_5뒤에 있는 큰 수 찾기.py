def solution(numbers):
    
    n=len(numbers)
    l=[ -1 for i in range(n)]
    stack=[]#스택 이용하는 문제
    
    #첫번쨰건 넣고 시작
    stack.append(numbers[-1])
    
    for i in range(n-2,-1,-1):
        #print(stack)
        cur=numbers[i]
        while True: 
            if len(stack)==0:
                break
   
            top=stack[-1]    
            if cur<top:
                l[i]=top
                break
                
            stack.pop()
            
        stack.append(cur)
            
        
    return l
