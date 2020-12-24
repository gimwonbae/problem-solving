from sys import stdin


def n_and_m():
    def dfs(depth):
        if depth == m:
            print(f'{" ".join(result)}')
            return
        for i in arr:
            if i not in visited:
                visited.append(i)
                result.append(str(i))
                dfs(depth+1)
                visited.pop()
                result.pop()

    n, m = map(int, stdin.readline().rstrip().split())

    arr = [i + 1 for i in range(n)]
    visited = []
    result = []
    dfs(0)


n_and_m()