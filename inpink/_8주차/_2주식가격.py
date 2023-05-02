def solution(prices):
    
    lenn=len(prices)
    answer = [ i for i in range(lenn-1,-1,-1)]
    
    #☆스택을 쓰는 문제!
    stack=[0] 
    #print(prices,answer,stack)
    
    for i in range(1,lenn):
        while stack and prices[stack[-1]]>prices[i]:
            topIdx=stack.pop()
            answer[topIdx]=i-topIdx
        stack.append(i)
    return answer

#solution([1, 2, 3, 2, 3])
