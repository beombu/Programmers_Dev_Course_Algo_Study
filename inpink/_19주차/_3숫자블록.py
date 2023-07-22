def solution(begin, end):
    MAX = 10000001
    answer = []
    for i in range(begin, end + 1):
        if i==1: num = 0 
        else: num=1

        for j in range(2, int(i ** 0.5) + 1):
            if i % j == 0 and i // j < MAX:
                num = i // j
                break
        answer.append(num)

    return answer
