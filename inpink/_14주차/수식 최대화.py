def solution(expression):
    answer = 0
    
    '''
    구현 방법
    공통점 : 길이가 매우 짧다.  연산자가 3개이다. 3개의 연산자에 대해 순열을 만들어서 써야 한다.(직접 만들어주거나, permutation 이용) 이 중, 절대값이 가장 큰 값을 반환한다.
    
    1. 재귀를 이용한 방법
    => 우선순위가 낮은 연산자부터 잘라서, 잘린 결과를 재귀로 보낸다. 3번째 재귀에서 계산하여 반환한다. 받은 값을 이용하여 2번째 재귀에서 계산하여 반환한다. 1번째 재귀도 마찬가지이다. 
    eval()을 이용한다. string으로 되어 있는 계산식을 계산해주는 함수이다.

    2. 완전 탐색
   => for을 이용해서 하나하나 접근하며 직접 연산식을 잘라주는 과정이 필요하다. 
   우선 순위의 연산자는 바로 계산하고, 리스트를 업데이트 시켜준다. ( pop, insert를 이용하여 비효율적일 수 있음) 다시 처음으로 돌아간다. 
   모든 연산자가 계산될 때까지 반복한다.
   
    '''
        
    #등장하는 연산자 3가지, 우선순위 종류는 아래와 같다 (permutation 이용해도 됨)
    priorities = [
        ('*', '-', '+'), #+ > - > * 순서대로 우선순위 높음 
        ('*', '+', '-'),
        ('+', '*', '-'),
        ('+', '-', '*'),
        ('-', '*', '+'),
        ('-', '+', '*')
    ]
    
    for priority in priorities:
        res = int(calc(priority, 0, expression))
        answer = max(answer, abs(res))

    return answer


#재귀 이용한 방식
def calc(priority, n, expression):
    if n == 2: #3번째 재귀에서 계산함 
        return str(eval(expression)) #eval이용. 반환값은 string형으로 
    if priority[n] == '*':
        res = eval('*'.join([calc(priority, n+1, e) for e in expression.split('*')]))
    if priority[n] == '+':
        res = eval('+'.join([calc(priority, n+1, e) for e in expression.split('+')]))
    if priority[n] == '-':
        res = eval('-'.join([calc(priority, n+1, e) for e in expression.split('-')]))
    return str(res)
