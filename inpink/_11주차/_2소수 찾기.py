from itertools import permutations #순열 라이브러리 이용

def solution(numbers):
    answer = 0
    n=len(numbers)

    pers=[]
    for i in range(1, n+1):   
        pers.append(list(permutations(numbers, i))) #자바에서는 순열, 조합 라이브러리가 없기에, "재귀/백트래킹"로 직접 구해줘야 함. 
    
    s=set()
    for i in pers:
        for j in i:
            candi=int("".join(j)) #★join으로 문자열 하나로 합치기
            if (candi not in s):
                s.add(candi)
                if isPrime(candi): 
                    answer+=1
                    #print(candi)
    
    return answer

#소수인지
def isPrime(m):
    if m<=1:
        return False
    
    for i in range(2,int(m**0.5)+1):
        if m%i==0:
            return False
        
    return True
