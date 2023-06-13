def solution(n, wires):
    answer = 100
    wireLen=len(wires)
    #같은 그룹에 속하는지 세기 위해 union-find
    #어떻게 끊어도 하나를 끊으면 두개로 나뉘게 됨 
    
    for i in range(wireLen):
        arr=[ a for a in range(n+1)] #union find 부모 체크 arr
        
        for j in range(wireLen):
            if j==i: #각 경우당 하나씩 빼서 완전 탐색(brute force)
                continue
                
            #1차적으로 union-find
            left,right=wires[j]
            leftP=find(arr,left)
            rightP=find(arr,right)
            
            arr[leftP]=rightP
        #print(arr)
        
        #다시 한 번씩 union find해서 진짜 부모를 찾고, 송신탑 개수 차를 구함
        map={}
        for j in range(1,n+1):
            p=find(arr,j)
            
            if p in map:
                map[p]+=1
            else:
                map[p]=1
        a,b=map.values() #map을 이용하여 구함
        answer=min(answer,abs(b-a))
        #print(arr,map)
        #print()
        
    return answer


#union-find main logic
def find(arr,num):
    if arr[num]==num:
        return num
    
    arr[num]=find(arr,arr[num])
    return arr[num];

