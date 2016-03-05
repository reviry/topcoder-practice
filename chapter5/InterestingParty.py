"""
 SRM494 Div 2 Level 1
"""

import time

def best_invitation(first, second):
    answer = 0
    for i in xrange(len(first)):
        f = 0
        s = 0
        for j in xrange(len(first)):
            if first[i] == first[j]:
                f += 1
            if first[i] == second[j]:
                f += 1
            if second[i] == first[j]:
                s += 1
            if second[i] == second[j]:
                s += 1

        answer = max(f, s, answer)
        return answer

if __name__ == '__main__':
    count = 0
    for line in open('../testcase/InterestingParty.txt', 'r'):
        count += 1
        if count == 1:
            first = line[: -1].split(' ')
        if count == 2:
            second = line[: -1].split(' ')
        if count == 3:
            answer = int(line)

            start = time.time()
            result = best_invitation(first, second)
            end = time.time()

            if result == answer:
                print 'PASS!'
            else:
                print 'FAILURE!'

            print ("Time: {0}".format((end - start) * 1000)) + "[ms]"
            count = 0
