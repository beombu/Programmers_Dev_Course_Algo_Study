def solution(p):
    #문제에서 요구한대로 구현하면 되는 문제. "재귀"
    
    #1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    if p == '':
        return p
    
    #2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
    u, v = divide(p)
    
    #3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
    #3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
    if check(u)==True:
        return u + solution(v)
    
    #4. 문자열 u가 "올바른 괄호 문자열"이 아니라면     
    ans = '('+solution(v)+')' #4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.  4-3. ')'를 다시 붙입니다.  
    
    #4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
    for x in u[1:-1]:
        if x == '(':
            ans += ')'
        else:
            ans += '('
            
    #4-5. 생성된 문자열을 반환합니다.        
    return ans


def divide(p):
    left, right = 0, 0
    for k in range(len(p)):
        if p[k] == '(':
            left += 1
        else:
            right += 1
        if left == right:
            return p[:k+1], p[k+1:]
        
def check(u):
    stack = []
    for x in u:
        if not stack:
            stack.append(x)
        else:
            if x == ')' and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(x)
                
    if len(stack)!=0:
        return False
    
    return True
