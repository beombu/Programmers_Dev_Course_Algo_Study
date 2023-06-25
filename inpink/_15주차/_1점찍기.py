import math

def solution(k, d):
    answer = 0
    
    #x 기준으로 한 줄씩 세기
    for x in range(0, d + 1, k):
        answer += (math.floor(math.sqrt(d*d - x*x)) // k) + 1 #+1은 (x,0) 자신
        
    return answer 
