from sys import stdin


def not_dup_sort():
    n = int(stdin.readline().rstrip())
    arr = list(set(map(int, stdin.readline().rstrip().split(' '))))
    arr.sort()

    for i in arr:
        print(i, end=' ')


not_dup_sort()
