import sys
import collections


def sort_n():
    n = int(sys.stdin.readline().rstrip())
    arr = collections.defaultdict(int)

    if 1 <= n <= 10000000:
        for i in range(n):
            item = int(sys.stdin.readline().rstrip())
            arr[item] = arr[item] + 1

    for i in range(1,10001):
        for j in range(arr[i]):
            print(i)


sort_n()