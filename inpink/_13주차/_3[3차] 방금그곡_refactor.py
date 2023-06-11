import datetime as dt

def solution(m, mus):
    answer = "(None)"
    ansTime=0
    
    #m 자르기
    s=m.replace('C#','c').replace('D#','d').replace('F#','f').replace('A#','a').replace('G#','g')

    # ,를 기준으로 문자열 잘라주기
    sepMus=[]
    for i in mus:
        startT,endT,songName, musicS= i.split(',')
        calMin=calTime(startT,endT)
        sepMus.append( [songName, musicS,calMin ]) #곡명, 뮤직, 재생길이


    for i in sepMus:
        songName, musicS,calMin =i
        seperMusic=musicS.replace('C#','c').replace('D#','d').replace('F#','f').replace('A#','a').replace('G#','g')
        musicLen =len(seperMusic)
        
        song = (seperMusic*max(1, int(calMin/len(seperMusic))+1))[:calMin]
        print(s,seperMusic,song,ansTime,calMin)
        if s in song and ansTime<calMin:
            ansTime=calMin
            answer=songName

    
    return answer


def calTime(startT, endT): #분으로 반환
    
    startH,startM= map(int,startT.split(':')) #int로 변환
    endH,endM= map(int,endT.split(':'))
    
    calT=dt.timedelta(hours=endH, minutes=endM) - dt.timedelta(hours=startH, minutes=startM)
    calMin=calT.seconds//60 #분으로 변환
    
    return calMin
          


