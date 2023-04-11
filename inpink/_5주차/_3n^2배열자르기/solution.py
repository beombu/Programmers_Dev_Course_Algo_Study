def solution(n, left, right):
    ans = []
    for i in range(left,right+1):
        a=i//n #행
        b=i%n#열
        #print(a,b)
        ans.append(max(a,b)+1)
        
    return ans
