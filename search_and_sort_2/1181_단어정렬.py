import sys
from collections import defaultdict


def sort_word():
    n = int(sys.stdin.readline().rstrip())
    arr = defaultdict(list)

    for _ in range(n):
        word = sys.stdin.readline().rstrip()
        arr[len(word)].append(word)

    for i in range(1, 51):
        not_dup = list(set(arr[i]))
        not_dup.sort()
        for j in not_dup:
            print(j)


sort_word()