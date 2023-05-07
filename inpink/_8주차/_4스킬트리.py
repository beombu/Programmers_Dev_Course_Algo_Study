def solution(skill, skill_trees):
    answer = 0
    
    lenSkill=len(skill)
    dic={}
    for i in range(lenSkill):
        key=skill[i]
        dic[key]=i
    #print(dic)
    
    for i in skill_trees:
        before=0
        for j in i:
            if j in dic:
                keyIndex=dic[j]
                if keyIndex!=before:
                    before=999
                    break
                else:
                    before+=1
        if before!=999:
            #print(i)
            answer+=1
            
            
    return answer