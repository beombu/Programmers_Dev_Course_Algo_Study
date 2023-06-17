import math

def solution(n, k):
    answer = []
    a= [ i for i in range(1,n+1)]
    
    #순열 이용시 시간 초과
    #k=2,432,902,008,176,640,000
    
    while True:
        if (k<=1) : break
        fac=math.factorial(len(a)-1)
        tmp=(k-1)//fac
        answer.append(a.pop(tmp)) #tmp번째 값을 answer list에 넣기 (a크기 최대20라 문제없음)
        k-= fac*tmp
        
    answer+=a
    return answer
