def solution(want, number, discount):
    answer = 0
    n=len(want)
    l=[]
    for i in range(n):
        for j in range(number[i]):
            l.append(want[i])    
    l.sort()
    #print(l)
    for i in range(len(discount[:-len(l)+1])):
        if l==sorted(discount[i:len(l)+i]):
            answer+=1
    return answer
