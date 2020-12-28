from sys import stdin
from collections import defaultdict


def sort_xy():
    n = int(stdin.readline().rstrip())
    arr = defaultdict(list)

    for _ in range(n):
        xy = list(map(int, stdin.readline().rstrip().split(' ')))
        arr[xy[0]].append(xy[1])

    for i in range(-100000, 100001):
        arr[i].sort()
        for j in arr[i]:
            print(i, j)


sort_xy()
