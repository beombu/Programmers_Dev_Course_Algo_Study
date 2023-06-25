def time2val(time):
    hour,min=map(int,time.split(":"))
    return hour * 60 + min

def solution(book_time):
    dic = {}
    for book in book_time:
        st = time2val(book[0])
        en = time2val(book[1])
        for t in range(st,en+10):
            if t not in dic:
                dic[t] = 1
            else:
                dic[t] += 1
    
    return max(dic.values()) 
