from sys import stdin


def n_and_m():
    def dfs(depth):
        if depth == m:
            print(f'{" ".join(result)}')
            return
        for i in arr:
            result.append(str(i))
            dfs(depth+1)
            result.pop()

    n, m = map(int, stdin.readline().rstrip().split())

    arr = [i + 1 for i in range(n)]
    result = []
    dfs(0)


n_and_m()