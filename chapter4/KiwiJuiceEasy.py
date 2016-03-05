"""
SRM478 Div 2 Level 1
"""

import time

def thePouring(capacities, bottles, fromId, toId):
    for i in xrange(len(fromId)):
        sum = bottles[fromId[i]] + bottles[toId[i]]
        bottles[toId[i]] = min(capacities[toId[i]], sum)
        bottles[fromId[i]] = sum - bottles[toId[i]]

    return bottles

if __name__ == '__main__':
    count = 0
    for line in open('../testcase/KiwiJuiceEasy.txt', 'r'):
        count += 1
        tmp = map(int, line[: -1].split(' '))
        if count == 1:
            capacities = tmp
        elif count == 2:
            bottles = tmp
        elif count == 3:
            fromId = tmp
        elif count == 4:
            toId = tmp
        else:
            answer = tmp

            start = time.time()
            result = thePouring(capacities, bottles, fromId, toId)
            end = time.time()

            if result == answer:
                print "PASS!!"
            else:
                print "FALSE!!"

            print ("Time: {0}".format((end - start) * 1000)) + "[ms]"
            count = 0
