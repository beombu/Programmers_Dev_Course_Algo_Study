def solution(s):
    ans=[]
    n=len(s)
    
    #brute force 검사
    for i in range(1, n+1):
        b = ""
        cnt = 1
        tmp=s[:i] #문자열 문제

        for j in range(i, n+i, i):
            if tmp==s[j:i+j]:
                cnt+=1
            else:
                if cnt!=1:
                    b +=str(cnt)
                b+=tmp
                
                #초기화
                tmp=s[j:j+i]
                cnt = 1
                
        ans.append(len(b))       
    #print(ans)
    return min(ans)
