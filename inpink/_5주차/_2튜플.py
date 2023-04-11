def solution(s):
    answer = []
    tmp=""
    tmp_list=[]
    for i in s:
        if i=="{":
            continue
        elif i=="}":
            tmp_list.append(tmp+',')
            tmp=""
        else : tmp+=i
    tmp_list.sort(key=len)
    #print(tmp_list)
    
    nums=set()
    for i in tmp_list:
        tmp=""
        for j in i:
            if j==',':
                if tmp=='': continue
                if int(tmp) not in nums:
                    answer.append(int(tmp))
                    nums.add(int(tmp))
                tmp=""
            else:
                tmp+=j
    #answer.append(int(tmp))
    return answer
