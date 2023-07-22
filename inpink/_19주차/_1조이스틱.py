def solution(name):
    answer = 0
    
    num_list = [min(abs(ord('A')-ord(n)), 26-abs(ord('A')-ord(n))) for n in name]
    print(num_list)
    answer += sum(num_list)
    min_move = len(name) -1
    
    for i, c in enumerate(name):
        #print(i,c)
        next_i = i+1
        
        while True:
            if (next_i >= len(name) or name[next_i] != 'A'): break
            else: next_i += 1
            
        min_move = min(min_move, 2*i+ len(name)-next_i, 2*(len(name)-next_i)+i)
        print(min_move)
    
    return answer+min_move
