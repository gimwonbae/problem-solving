from sys import stdin

cnt = 0


def n_queen():
    def dfs(depth):
        global cnt
        if depth == n:
            cnt += 1
            return
        for i in range(1, n+1):
            if i not in visited and abs(depth - i) not in diag:
                visited.append(i)
                diag.append(abs(depth - i))
                dfs(depth + 1)
                diag.pop()
                visited.pop()

    n = int(stdin.readline().rstrip())
    visited = []
    diag = []
    print(cnt)


n_queen()