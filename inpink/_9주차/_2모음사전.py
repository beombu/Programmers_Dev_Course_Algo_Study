def solution(word):
    answer = 0
    l=['','A','E','I','O','U']
    s=set()
    for a in range(1,6):
        for e in range(6):
            for i in range(6):
                for o in range(6):
                    for u in range(6):
                        s.add(l[a]+l[e]+l[i]+l[o]+l[u])
    dicL=list(s)
    dicL.sort()
    #print(dicL)
    answer=dicL.index(word)+1
    #print(dicL[:10])
    return answer
