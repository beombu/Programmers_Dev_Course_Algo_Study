import math
def solution(fees, records):
    ans = {}
    nums=[]
    d={}
    for i in records:
        tmp=i.split(" ")
        if tmp[1] not in d:
            ans[tmp[1]]=0
            nums.append(tmp[1])
            d[tmp[1]]=[[tmp[0][0:2],tmp[0][3:5],tmp[2]]]            
        else: 
            d[tmp[1]].append([tmp[0][0:2],tmp[0][3:5],tmp[2]])
    nums.sort()
    
    for i in d:
        stack=[]
        for j in d[i]:
            if j[2]=="IN":
                stack.append([int(j[0]), int(j[1])])
            else:
                tmp시, tmp분=stack.pop()
                ans[i]+=시간계산(tmp시, tmp분, int(j[0]), int(j[1]))
     
        #만약 출차기록이 하나 없는 경우
        if len(stack)!=0:
            tmp시, tmp분=stack.pop()
            ans[i]+=시간계산(tmp시, tmp분, 23,59)

        ans[i]=돈계산(ans[i],fees)

    final=[]
    for i in nums:
        final.append(ans[i])
    return final

def 시간계산(시, 분, 시2, 분2):
    시=시*60+분
    시2=시2*60+분2
    return 시2-시

def 돈계산(time,fees):
    fee=0
    if time<fees[0]: #기본시간 내
        fee+=fees[1]
    else:
        fee+=fees[1]
        rest=time-fees[0]
        fee+=(math.ceil(rest/fees[2])*fees[3])
    return fee


print(solution([180, 5000, 10, 600],["05:34 5961 IN", "06:00 0000 IN",
                                     "06:34 0000 OUT", "07:59 5961 OUT",
                                     "07:59 0148 IN", "18:59 0000 IN",
                                     "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))

