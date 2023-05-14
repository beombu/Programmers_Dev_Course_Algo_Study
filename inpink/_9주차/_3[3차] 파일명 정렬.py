from collections import deque

def solution(files):   
    answer = [] #정답 담아줄 list
    headDic={} #head : [head에 해당하는 number들의 원래 index]. 같은 head에 대해, 숫자들을 정렬하기 위해 사용
    headList=[] #head들을 담아둠. sort해서 오름차순으로 answer에 담아주기 위함
    numDic={} #(head+num): [해당되는 number들의 원래 index].  01과 1의 순서를 지켜주기 위해 index를 입력된 순서대로 담아줌
    numList=[] #num들을 담아둠. 01->1으로 처리해줌. 정렬해줌. 01이 먼저인지 1이 먼저인지는, numDic에 순서대로 입력된 index를 이용하면 됨 
    
    for i in range(len(files)):
        #print(분리(i))
        head,num=분리(files[i])
        
        #headDic 만들기 
        if head in headDic:
            headDic[head].append(i)
        else:
            headDic[head]=[i]
            headList.append(head)
        
        #numList 만들기 
        numList.append(num)
        
        #numDic 만들기
        headNum=head+str(int(num)) #a01, a1 -> 'a1'이라는 이름으로 dic의 key를 지정해줌. value는 원래 이 값들의 index [3,4] 
        if headNum in numDic:
            numDic[headNum].append(i)
        else:
            numDic[headNum]=deque([i])
        
    #정렬
    headList.sort()
    #print(headDic,headList,numList,numDic)
    
    #ans 리스트에 담아주기.  
    for head in headList:  #1. headlist에 오름차순된 순서대로
        #2. 같은 head가 여러개라면, 각 head의 num값들(numList에서 index 이용하여 꺼냄)을 오름차순하여 tmp에 담아둠.
        tmp=[]
        for i in headDic[head]:
            tmp.append(int(numList[i]))
        tmp.sort()  #3. 정렬함. 1 1 2 2 10 12가 됨. 
        #print(tmp)
        
        #4. 1 1에서 어떤 01 1이 우선인지는, numDic에서 담겨있는 index를 이용하면 됨.  key=head+tmp값, value=idx도출 => files[idx]로 ans에 담음
        #이 때, deque를 이용해서 입력된 순서가 먼저 ans 리스트에 들어갈 수 있도록 함. 
        for j in tmp:
            idx=numDic[head+str(j)].popleft() #popleft()
            answer.append(files[idx])
    
    return answer


def 분리(s): 
    head=0 #head 끝index 
    number=0 #number 끝 index
    #tail은 이 문제에서 필요가 없다
    
    #head끝 index 탐지
    for i in range(len(s)):  
        if s[i].isdigit():
            head=i-1
            break
    
    #number 끝 index 탐지
    for i in range(head+1,head+6): #숫자는 최대 5자리까지만
        if i>=len(s) or not(s[i].isdigit()): #기존 s 범위를 벗어나거나, 숫자가 아닌수가 나오면 number 끝인거임 
            number=i-1
            break
        if i==head+5: #마지막 문자까지 왔는데도 계속 숫자가 나오고 있으면, 체크해줘야함
            number=i
            break

    ans=(s[0:head+1].lower(), s[head+1:number+1]) #문자로 만들어 반환 
    return ans #tuple형으로 반환 
    
