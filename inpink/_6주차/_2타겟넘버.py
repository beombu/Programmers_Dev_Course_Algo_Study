def solution(numbers, target):
    arr = [0]
    for i in numbers:
        tmp=[]
        for j in arr:
            tmp.append(j+i)
            tmp.append(j-i)
        arr = tmp
        #print(arr)
    return arr.count(target)
