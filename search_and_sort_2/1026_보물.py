import sys


def treasure():
    n = int(sys.stdin.readline().rstrip())
    a_arr = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    b_arr = list(map(int, sys.stdin.readline().rstrip().split(' ')))

    result = 0
    for _ in range(n):
        result += (a_arr.pop(a_arr.index(min(a_arr))) * b_arr.pop(b_arr.index(max(b_arr))))

    print(result)


treasure()
