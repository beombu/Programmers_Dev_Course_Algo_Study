def solution(picks, minerals):
    answer = 0
    summ = 0#총 곡괭이 수
    for i in picks: 
        summ += i
    
    num = summ * 5  #총 캘 수 있는 광물 수 
    if len(minerals)>summ: #더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
        minerals = minerals[:num]
    
    #5개단위로 끊어서 다이아, 철, 돌 개수 셈
    new_minerals =[[0,0,0] for _ in range((len(minerals) //5 +1))]
    for i in range(len(minerals)):
        if minerals[i]=='diamond':
            new_minerals[i//5][0]+=1
        elif minerals[i]=='iron':
            new_minerals[i//5][1]+=1
        elif minerals[i]=='stone':
            new_minerals[i//5][2]+=1
    
    #다이아가 제일 많은 순서->철이 제일 많은 순서-> 돌이 제일 많은 순서대로 
    new_minerals.sort(key=lambda x:(-x[0],-x[1],-x[2]))
    
    #남은 곡괭이 개수 고려해서 피로도 계산
    for i in new_minerals:
         dia,iron,stone = i
         for j in range(len(picks)):
            if picks[j]==0:
                continue
                
            if  j==0:
                picks[j]-=1
                answer += dia + iron + stone
                break
            elif j==1:
                picks[j]-=1
                answer += (5*dia) + iron + stone
                break
            elif j==2:
                picks[j]-=1
                answer += (25*dia) + (5*iron) + stone
                break
    
    return answer
