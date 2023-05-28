def solution(topping):
    
    #O(2n)으로 해결 가능한 문제
    #자료구조를 잘 써주면 됨
    
    answer = 0
    n=len(topping)
    
    leftCount=0
    rightCount=0
    
    leftVisited=[ 0 for i in range(10001)]
    rightVisited=[ 0 for i in range(10001)]
        
        
    for i in range(n):
        cur=topping[i]
        if (rightVisited[cur]==0): 
            rightCount+=1
        
        rightVisited[cur]+=1   
        
    for i in range(n):
        cur=topping[i]
        if leftVisited[cur]==0: 
            leftCount+=1
        leftVisited[cur]+=1
        rightVisited[cur]-=1
        
        if rightVisited[cur]==0:
            rightCount-=1

        
        if leftCount==rightCount:
            #print(topping[:i],topping[i:])
            answer+=1
    
        
    return answer
