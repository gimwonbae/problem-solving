import bisect

def find_number():
    n = int(input())
    nlist = list(map(int, input().split(' ')))
    m = int(input())
    mlist = list(map(int, input().split(' ')))
    nlist.sort()

    for i in range(m):
        flag = 0
        low = 0
        high = n - 1

        while(low <= high):
            mid = (low + high) // 2
            if nlist[mid] < mlist[i]:
                low = mid + 1
            elif nlist[mid] > mlist[i]:
                high = mid - 1
            else:
                flag = 1
                break
        print(flag)

find_number()