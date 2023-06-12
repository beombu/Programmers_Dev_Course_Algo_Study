from collections import deque
from itertools import permutations


def operation(op, nums):
    if op == '+':
        return sum(nums)
    elif op == '-':
        return nums[0] - nums[1]
    elif op == '*':
        return nums[0] * nums[1]


def calc(priority, exp):
    for i in priority:
        j = 0
        while j < len(exp):
            if exp[j] == i:
                exp[j-1:j+2] = [operation(i, [int(exp[j-1]), int(exp[j+1])])]
                continue
            j += 1
    return abs(exp[0])


def solution(expression):
    answer = []
    exp = deque()
    lastIdx = -1
    for i in range(len(expression)):
        if not expression[i].isdigit():
            exp.append(expression[lastIdx+1:i])
            exp.append(expression[i])
            lastIdx = i
    exp.append(expression[lastIdx+1:])
    priority = list(permutations(['+', '-', '*'], 3))
    for i in priority:
        answer.append(calc(i, list(exp.copy())))

    return max(answer)
