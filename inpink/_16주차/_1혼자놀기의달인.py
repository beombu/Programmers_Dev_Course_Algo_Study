def solution(cards):
    answer = []
    n=len(cards)
    
    for i in range(n):
        tmp = 0
        while True:
            if cards[i]==0:
                break
            nextI = cards[i] - 1
            cards[i]=0
            i=nextI
            tmp += 1 #개수를 세어 점수를 구하는것이므로 개수만 answer에 담아주면 된다
        answer.append(tmp)
        print(answer)
    answer.sort()

    return answer[-1] * answer[-2] 
