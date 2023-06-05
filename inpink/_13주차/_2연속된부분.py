def solution(seq, k):
    candi=[]
    n=len(seq)
    #투포인터
    
    left=0
    right=0
    summ=0
    while True:
        
        if summ==k:
            candi.append([right-left,left,right-1])
            
        #right 포인터가 맨 끝을 가리키는 상태에서, 합이 k보다 작으면, 더 이상 탐색할 이유가 없다 
        if right>=n and summ<=k: 
            #print(left,right,summ)
            break    
        
        #right포인터는 무조건 맨 끝에서 끝나게 됨. left 포인터는 탐색할수 있는 범위까지(위 주석 참고)
        if summ<=k:
            summ+=seq[right]
            right+=1
        elif summ>k:
            summ-=seq[left]
            left+=1
        
        #print(summ)
    #print(candi)
    
    candi.sort()
    
    return [candi[0][1],candi[0][2]]
