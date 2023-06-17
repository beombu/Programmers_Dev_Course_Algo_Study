from collections import deque


def solution(rows, columns, queries):
    arr = [[(i*columns) + (j + 1)for j in range(columns)]for i in range(rows)]
    answer = []
    for i in queries:
        x1, y1, x2, y2 = i
        tmp = 0
        nums = deque()
        for a in range(y1-1, y2):
            if tmp == 0:
                tmp = arr[x1-1][a]
                continue
            arr[x1-1][a], tmp = tmp, arr[x1-1][a]
            nums.append(tmp)

        for a in range(x1, x2):
            arr[a][y2-1], tmp = tmp, arr[a][y2-1]
            nums.append(tmp)
        for a in range(y2-2, y1-2, -1):
            arr[x2-1][a], tmp = tmp, arr[x2-1][a]
            nums.append(tmp)
        for a in range(x2-2, x1-2, -1):
            arr[a][y1-1], tmp = tmp, arr[a][y1-1]
            nums.append(tmp)
        answer.append(min(nums))

    return answer
