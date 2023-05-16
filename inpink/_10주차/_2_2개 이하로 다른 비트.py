def solution(numbers):
    #numbers=[10**15]
    answer = []
    
    #숫자의 범위는 2^50(10^15)지만
    #brute force : 각 number부터 10^15까지 50번씩 해주는걸 10만번 하면 시간초과 무조건
    
    #규칙 발견
    #☆ 2진수 더하기하는 방법을 생각해보면 됨
    #num이 짝수 => ★2진수 맨 마지막이 0임 => +1이 정답
    #num이 홀수 => 가장 작은 자리수의 0을 1으로, 그 이전 자리수 1을 0로
    
    for i in numbers:
        if i%2==0: #짝
            answer.append(i+1)
        else: #홀
            zeroIdx=findOne(i) 
            beforeOneIdx=zeroIdx-1
            #print(i,zeroIdx)
            ans= i+(1<<zeroIdx)-(1<<beforeOneIdx) #비트마스킹 이용 
            answer.append(ans)
            
    return answer
            
def findOne(num):
    #1<<50은 2진수로 51자리수.
    #2^50은 50자리 수까지 나올 수 있다. 
    #2진수로 1이 50개 있을 수 있으므로(물론 이 문제에서 숫자의 범위가 그렇게까진 아니지만 넉넉하게)
    #50자리수까지 1이 나올 수 있으므로 51자리까지 0인지 검사해주면 된다
    for i in range(50): 
        if not (num & 1<<i): #★1<<0은 1, 1<<1은 2, 1<<2는 4... 
            return i
            
