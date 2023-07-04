#시키는 대로 구현하면 되는 문제
def solution(data, col, row_begin, row_end): #1. 입력
    answer = 0
    
    #2. 정렬
    data = sorted(data, key = lambda x: [x[col - 1], -x[0]])
    
    for i in range(row_begin, row_end + 1): #3
        total = 0
        for j in data[i - 1]:
            total += (j % i)
        answer ^= total #4. XOR
            
    return answer
