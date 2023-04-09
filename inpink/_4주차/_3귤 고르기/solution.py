def solution(k, tangerine):
    d={}
    for i in tangerine:
        if i not in d:
            d[i]=1;
        else:
            d[i]+=1;
    #print(d)
    
    l=[]
    for i in d:
        l.append([d[i],i])
    l.sort(reverse=1)
    #print(l)
    
    summ=0
    count=0
    for a,b in l:
        if summ>=k:
            return count
        count+=1
        summ+=a
    return count
