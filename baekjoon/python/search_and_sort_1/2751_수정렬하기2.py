import sys


def sort_n():
    n = int(sys.stdin.readline().rstrip())
    arr = list()

    if 1 <= n <= 10000000:
        for i in range(n):
            arr.append(int(sys.stdin.readline().rstrip()))

    arr.sort()

    for i in range(n):
        print(arr[i])


sort_n()