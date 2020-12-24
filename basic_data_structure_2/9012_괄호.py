from sys import stdin


def vps():
    n = int(stdin.readline().rstrip())

    for _ in range(n):
        cnt = 0
        line = stdin.readline().rstrip()
        flag = True

        for char in line:
            if char == '(':
                cnt = cnt + 1
            elif char == ')':
                cnt = cnt - 1
                if cnt < 0:
                    flag = False
        if flag and cnt == 0:
            print('YES')
        else:
            print('NO')


vps()
