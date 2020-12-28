from sys import stdin
from collections import defaultdict


def sort_yx():
    n = int(stdin.readline().rstrip())
    arr = defaultdict(list)

    for _ in range(n):
        yx = list(map(int, stdin.readline().rstrip().split(' ')))
        arr[yx[1]].append(yx[0])

    for i in range(-100000, 100001):
        arr[i].sort()
        for j in arr[i]:
            print(j, i)


sort_yx()
