def solution(weights):
    answer = 0
    dic={}
    
    for i in weights:
        if i in dic:
            dic[i]+=1
        else:
            dic[i]=1
            
    print(dic)
    
    #자기보다 크거나 같은 것만 대상으로 세자 
    for num in dic:
        count=dic[num]
        if count>1:
            #answer += 1부터 count-1까지의 합
            #1부터num-1까지의 합 : num*(num-1)/2 이라는 공식을 쓰는 게 시간은 더 빠르긴 함
            for i in range(1,count):
                answer+=i
        if num*2 in dic:
            answer+=dic[num]*dic[num*2] #★dic[num]이 1이 아닌 경우도 있으니까! dic[num]도 곱해줘야 함!
        if num*3/2 in dic:
            answer+=dic[num]*dic[num*3/2]
        if num*4/3 in dic:
            answer+=dic[num]*dic[num*4/3]
        #print(num,count,answer)
        
    #==
    #*2
    #*3/2
    #*4/3
    return answer
