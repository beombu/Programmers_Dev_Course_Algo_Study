from heapq import *

def solution(scoville, K):
    answer = 0
    heap=[]
    for i in scoville:
        heappush(heap,i) #heap으로 변환 
        
    while True:
        #print(heap)
        if heap[0]>=K or len(heap)==1: #종료 조건 
            break
        heappush(heap,heappop(heap)+heappop(heap)*2) #heap을 이용하여 가장 작은 값과 두번째로 작은 값 빠르게 뽑아냄
        answer+=1
        
    if heap[0]<K: #마지막 음식이 K보다 작다= 최종 스코빌 지수가 K보다 작은 것이라 현재까지 쌓아진 answer값과 무관하게 -1 출력해야 함 
        answer=-1
        
    return answer
