from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    l=[0 for i in range(bridge_length)]
    bridgeQ=deque(l)
    leftTruckQ=deque(truck_weights)
    
    summ=0
    
    while True:
        if len(bridgeQ)==0:
            break
        answer+=1
        summ-=bridgeQ.popleft()
        
        if leftTruckQ:
            if summ+leftTruckQ[0]<=weight:
                newTruck=leftTruckQ.popleft()
                bridgeQ.append(newTruck) #새 트럭 넣기
                summ+=newTruck
            else:
                bridgeQ.append(0) #0을 넣어 다리 칸 유지
                
    return answer
