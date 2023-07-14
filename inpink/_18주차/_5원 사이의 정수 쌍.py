import math 
def solution(r1, r2):
    num = 0
    for x in range(1, r2 + 1):
        yMax = math.floor(math.sqrt(r2**2 - x**2))
        if x>=r1:
            yMin=0
        else:
            yMin=math.ceil(math.sqrt(abs(r1**2 - x**2)))

        num += yMax - yMin + 1
    
    return num * 4
