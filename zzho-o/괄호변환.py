def checkLogic(p):
    s = ""
    if not len(p): return s     #1
    u,v = splitUV(p)                 #2
    if checkCorrect(u):              #3
        s = u + checkLogic(v)
    else:                            #4
        tmp = '('                     #4-1
        tmp += (checkLogic(v)+')')           #4-2,4-3
        tmp += ''.join(list(map(convert,u[1:-1])))    #4-4
        s += tmp
    return s
        

def convert(s):
    if s == '(': return ')'
    else : return '('

def splitUV(s):
    # step 2
    # 왼쪽에서 최소 단위의 균형잡힌 문자열 분리
    cnt = 0
    for i in range(len(s)):
        if s[i] == '(':
            cnt += 1
        else:
            cnt -= 1
        if cnt == 0:
            u = s[:i+1]
            v = s[i+1:] if i+1 < len(s) else ""
            break
    return u, v

# 올바른 괄호 문자열 검사
def checkCorrect(u):
    cnt = 0
    for i in u:
        if i == '(':
            cnt += 1
        else:
            if cnt <= 0:
                return False
            cnt -= 1
    if cnt == 0:
        return True
    else:
        return False
def solution(p):
    if checkCorrect(p): return p
    answer = checkLogic(p)
    return answer

