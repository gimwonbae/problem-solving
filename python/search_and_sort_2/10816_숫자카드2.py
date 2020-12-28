import sys
from collections import Counter


def search_card():
    n = int(sys.stdin.readline().rstrip())
    n_arr = list(map(int, sys.stdin.readline().rstrip().split(' ')))

    cnt_arr = Counter(n_arr)

    m = int(sys.stdin.readline().rstrip())
    m_arr = list(map(int, sys.stdin.readline().rstrip().split(' ')))

    for m_item in m_arr:
        print(cnt_arr[m_item], end=' ')


search_card()