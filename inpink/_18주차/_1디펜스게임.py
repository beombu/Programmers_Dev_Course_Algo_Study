import heapq #힙을 사용한 문제

def solution(n, k, enemy):
    sumEnemy = 0
    heap = []
    lenn=len(enemy)
    
    for i in range(lenn):
        sumEnemy += enemy[i]
        heapq.heappush(heap,-1*enemy[i]) #마이너스값 넣어서 최대힙으로 사용
        
        if sumEnemy > n: #병사 다 쓴 시점에서
            if k == 0: #무적권 없다 
                return i  #enemy가 더 막을 수 없다 
            
            #★무작정 heap에서 큰거를 뽑으면 안 된다. 그 라운드까지 못갈 수 있기 때문.
            #병사가 초과된 시점에서 무적권 사용을 고려하자
            k -= 1 #무적권 사용
            sumEnemy += heapq.heappop(heap) #heap값은 마이너스이므로 sumEnemy가 줄어드는 효과 
            
    
    return i+1
