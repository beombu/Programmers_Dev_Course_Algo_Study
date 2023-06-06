from collections import deque
import datetime as dt

def solution(m, mus):
    answer = ''
    ansCandi=[]
    #m 자르기
    s=seper(m)
    #print("분리된 m:",s)

    # ,를 기준으로 문자열 잘라주기
    sepMus=[]
    for i in mus:
        startT,endT,songName, musicS= i.split(',')
        calMin=calTime(startT,endT)
        sepMus.append( [songName, musicS,calMin ]) #곡명, 뮤직, 재생길이

    #print("정제된 음악 정보:",sepMus)    

    ansCandiIdx=-1
    for i in sepMus:
        songName, musicS,calMin =i
        seperMusic=seper(musicS)
        musicLen =len(seperMusic)
        #print("각 뮤직 분리 :", seperMusic)

        sPointer=0
        for i in range(calMin):
            if s[sPointer]== seperMusic[i%musicLen]:
                sPointer+=1
            else: #★ 어차피 하나하나 비교해줘야 하는거면 문자열 만들어서 in을 써도 크게 문제없다.. 시간 줄이려면 다 구현하려 하지말고 어느 정도는 내장함수 쓰자
                sPointer=0

            if sPointer==len(s):
                ansCandi.append([calMin, ansCandiIdx, songName])
                ansCandiIdx-=1
                break
        
    if len(ansCandi)==0:
        answer="(None)"
    else:
        ansCandi.sort(reverse=True)
        answer=ansCandi[0][2] # 재생된 시간이 제일 긴 음악 제목을 반환한다.
        #재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
        
    #print(ansCandi)
    
    return answer


def calTime(startT, endT): #분으로 반환
    
    startH,startM= map(int,startT.split(':')) #int로 변환
    endH,endM= map(int,endT.split(':'))
    
    calT=dt.timedelta(hours=endH, minutes=endM) - dt.timedelta(hours=startH, minutes=startM)
    calMin=calT.seconds//60 #분으로 변환
    
    return calMin
          

def seper(s):
    n=len(s)
    idx=n-1
    ans=deque()
    
    while True:
        if idx<0:
            break
        
        char=s[idx]
        if char=='#':
            ans.appendleft( s[idx-1]+"#" )
            idx-=2
        else:
            ans.appendleft( char )
            idx-=1
    
    return ans

