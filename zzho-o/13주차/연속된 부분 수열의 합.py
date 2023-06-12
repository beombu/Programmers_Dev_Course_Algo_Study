def solution(sequence, k):
    # answer = []
    # 시간초과
    # p1, p2 = [0, 1]
    # length = 1e9
    # while p1 < p2 and p2 <= len(sequence):
    #     sum_ = sum(sequence[p1:p2])
    #     if sum_ == k:
    #         if length > p2-p1:
    #             answer = [p1, p2-1]
    #             length = len(sequence[p1:p2])
    #         p2 += 1
    #     elif sum_ < k:
    #         p2 += 1
    #     elif sum_ > k:
    #         p1 += 1
    answer = []
    p2 = 0
    sum_ = 0

    for p1 in range(len(sequence)):

        while p2 < len(sequence) and sum_ < k:
            sum_ += sequence[p2]
            p2 += 1

        if sum_ == k:
            if not answer:
                answer = [p1, p2-1]
            else:
                if answer[1] - answer[0] > p2 - 1 - p1:
                    answer = [p1, p2-1]

        sum_ -= sequence[p1]

    return answer


