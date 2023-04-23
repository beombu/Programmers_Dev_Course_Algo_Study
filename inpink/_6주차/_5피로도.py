from itertools import permutations

def solution(k, dungeons):
    answer = 0
    n=len(dungeons)
    l=list(permutations(range(0,n),n))
    print(l)
    for i in l:
        count=0
        tmp=k
        for j in i:
            if tmp>=dungeons[j][0]:
                count+=1
                tmp-=dungeons[j][1]   
        if answer<count:                          
            answer=count
    return answer
