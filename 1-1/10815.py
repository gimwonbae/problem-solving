import sys
import bisect


def search_card():
    n = int(sys.stdin.readline().rstrip())
    nArr = sys.stdin.readline().rstrip().split(' ')
    nArr = list(map(int, nArr))

    m = int(sys.stdin.readline().rstrip())
    mArr = sys.stdin.readline().rstrip().split(' ')
    mArr = list(map(int, mArr))

    nArr.sort()
    for i in range(m):
        index = bisect.bisect_left(nArr, mArr[i])
        print(int(index < n and nArr[index] == mArr[i]), end=' ')


search_card()