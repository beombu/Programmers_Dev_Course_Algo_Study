import itertools

def solution(users, emoticons):
    answer = []
    discountArr=[10,20,30,40]
    discountPermut = itertools.product(discountArr, repeat = len(emoticons))
    #for i in discountPermut: print(i) #최대 7개의 이모티콘에 각 4개의 선택지가 있는 순열 4^7=16,384

    #print("MIN, MAX RATE : ",minRate,maxRate)
    maxJoin=0
    maxPurchase=0
    

    #모든 이모티콘에 할인 적용한 금액 계산
    for i in discountPermut: #할인 후보 4^7

        #이번 할인 비율에서 각 유저가 구매한 비용 담음. users의 2차원 배열의 3번째 요소에 넣는걸로 구현해도 됨
        userPurSum=[ 0 for i in range(len(users))]   
        for j in range(len(emoticons)):  #모든 이모티콘 금액  7
            emoti=emoticons[j]
            discountRate=i[j] #할인 비율
            discountMoney=int(emoti*(100-discountRate)//100) #할인된 금액

            purchaseSum=0
            for k in range(len(users)):   #유저 희망 rate, money
                user=users[k]
                rateCondi=user[0]
                
                if rateCondi<=discountRate:
                    userPurSum[k]+=discountMoney

        #print("할인 비율",i)
        #print("고객 구매 비용",userPurSum)  

        joinCount=0
        nonJoinPurchase=0
        for k in range(len(users)):
            user=users[k]
            moneyCondi=user[1]

            userPur=userPurSum[k]

            if userPur>=moneyCondi: joinCount+=1
            else: nonJoinPurchase+=userPur
            
        if maxJoin<joinCount:
            maxJoin=joinCount
            maxPurchase=nonJoinPurchase
        elif maxJoin==joinCount:
            maxPurchase=max(maxPurchase,nonJoinPurchase)
            
        #print("maxJoin:",maxJoin,"\n")
            
    answer=[maxJoin, maxPurchase]        
    #print(answer)
    return answer

