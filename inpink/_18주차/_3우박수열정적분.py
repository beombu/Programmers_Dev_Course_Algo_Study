def solution(k, ranges):
    answer = []
    height = []
    width = []
    while True:
        if k==1: break
        
        height.append(k)
        
        if k % 2 == 0:
            k //= 2
        else:
            k = k * 3 + 1
            
    height.append(1)
    width.append((height[0] + height[1]) / 2)
    
    for i in range(1,len(height)-1):
        width.append((height[i] + height[i+1]) / 2 + width[i-1])
        
    for x,y in ranges:
        y = len(height)-1 + y
        if x > y:
            answer.append(-1.0)
        elif x == y:
            answer.append(0.0)
        else:
            if x == 0:
                answer.append(width[y-1])
            else:
                answer.append(width[y-1] - width[x-1])
    return answer
