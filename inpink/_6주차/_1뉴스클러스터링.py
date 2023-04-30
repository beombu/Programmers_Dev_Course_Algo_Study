def solution(str1, str2):
    answer = 0

    s1=세트생성(str1)
    s2=세트생성(str2)
    
    union={}
    다중집합(s1,union)
    다중집합(s2,union)
    #print(s1,s2,union)

    if len(union)==0:
        answer=1
    else:
        교집합수=0
        for i in s1:
            if i in s2:
                교집합수+=min(s1[i],s2[i])
        합집합수=0
        for i in union:
            합집합수+=union[i]
        answer=교집합수/합집합수
    
    return int(answer*65536)

def 세트생성(string):
    set1={}
    lenn=len(string)
    index=0
    
    while True:
        if (index>=lenn-1): break
        if string[index+1].isalpha()==False:
            index+=2
        elif string[index].isalpha()==True:
            part=(string[index:index+2]).lower()
            if part in set1:
                set1[part]+=1
            else:
                set1[part]=1
            index+=1
        else:
            index+=1
    return set1

def 다중집합(s1,union): 
    for i in s1:
        if i not in union:
            union[i]=s1[i]
        else:
            union[i]=max(union[i],s1[i])
