from sys import stdin
from itertools import combinations


def lotto():
    while True:
        s = stdin.readline().rstrip().split()
        if s[0] == '0':
            break
        s = s[1:]
        arr = combinations(s, 6)
        for x in arr:
            print(f'{" ".join(x)}')
        print('')


lotto()