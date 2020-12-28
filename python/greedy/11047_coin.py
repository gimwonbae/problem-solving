from sys import stdin


def coin():
    n, k = map(int, stdin.readline().rstrip().split())
    coins = []
    for _ in range(n):
        coins.append(int(stdin.readline().rstrip()))

    count = 0

    while k != 0:
        if coins[-1] <= k:
            count += k // coins[-1]
            k %= coins[-1]
        coins.pop()
    print(count)


coin()