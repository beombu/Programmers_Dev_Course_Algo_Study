def solution(numbers):
    answer = ''
    
    #정렬 조건을 직접 정해줘야 함
    #9,5,34,231,211,2가 있을 경우
    #0번째 자리가 우선, 0번째 자리가 같으면 1번째 자리를 비교.. 2번째 자리를 비교..
    #211과 2같은 경우, 2가 우선이다. #2 뒤의 자리에 최대 2가 올 수 있기 때문 
    #이를 표현하기 위해 숫자를 4번 반복시킴. 최대 천의 자리이기 때문이다. str으로 보면 211211211211보다 2222가 우선.
    
    strNum=[ str(i) for i in numbers ]
    strNum.sort(key=lambda x: x*4,reverse=True)
    
    for i in strNum:
        answer+=i
        
    return str(int(answer)) #[0,0]처럼 0만 나오는 경우, 00이 아닌 0이 되어야 함
