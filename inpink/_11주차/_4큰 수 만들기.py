def solution(number, k):
    answer = []
    
    #조합 이용하면 N^2 이상으로 시간초과
    #탐욕법(Greedy)  O(N)으로 해결가능 . 앞에서부터 순회하며, 앞에서부터 포기하도록 하면 됨
    #포기할 때, 스택을 이용해야 시간초과 안뜸
    for i in number:
        if len(answer) == 0:
            answer.append(i)
            continue
        if k>0:
            while answer[-1] < i:
                answer.pop()
                k -= 1
                if len(answer) == 0 or k <= 0 : break
        answer.append(i)

    if k>0:
        answer=answer[:-k]
    return ''.join(answer)
