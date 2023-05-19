
def solution(x, y, n):
    answer = 0
    
    d = [9999999999] * (y+1) 
    d[x] = 0
    
    for i in range(x, y+1):
        if i+n <= y:
            d[i+n] = min(d[i+n], d[i]+1)
        if i*2 <= y:
            d[i*2] = min(d[i*2], d[i]+1)   
        if i*3 <= y:
            d[i*3] = min(d[i*3], d[i]+1) 
    if d[y] == 9999999999:
        return -1
    else : return d[y]
