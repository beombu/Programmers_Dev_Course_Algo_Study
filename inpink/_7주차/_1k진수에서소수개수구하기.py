def solution(n, k):
    ans = 0

    trans=str(k진수변환(n,k))
    cand=검사후보(trans)

    for i in cand:
        if 소수(i)==True: #중복되는것도 세어야 한다
            ans+=1
            
    return ans

def 소수(m): 
    if m<=1:
        return False
    
    for i in range(2,int(m**0.5)+1):
        if m%i==0:
            return False
          
    return True

def k진수변환(n,k):
    trans=0
    turn=0
    
    while True:
        if n==0:
            break
        trans+=(10**turn)*(n%k)
        n//=k
        turn+=1
    
    return trans

def 검사후보(trans):
    tmp=''
    cand=[]
    for i in range(len(trans)):
        if trans[i]=='0' and tmp!='':
            cand.append(int(tmp))
            tmp=''
        else:
            tmp+=trans[i]
            
    #마지막에 남아있을 수 있다
    if tmp!='' : cand.append(int(tmp))
                                 
    return cand
