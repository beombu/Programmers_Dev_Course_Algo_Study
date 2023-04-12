def solution(clothes):
    총개수=len(clothes)
    dic={}
    ans = 1
    
    for b,a in clothes:
        if a not in dic:
            dic[a]=1
        else:
            dic[a]+=1
            
    for i in list(dic.values()):
        ans*=(i+1)
        
    ans-=1
    
    
    return ans
