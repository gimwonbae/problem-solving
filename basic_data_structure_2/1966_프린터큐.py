from sys import stdin


def printer():
    n = int(stdin.readline().rstrip())
    for _ in range(n):
        m, index = map(int, stdin.readline().rstrip().split(' '))
        queue = list(map(int, stdin.readline().rstrip().split(' ')))
        cnt = 0

        while queue:
            if queue[0] < max(queue):
                queue.append(queue.pop(0))
                if index == 0:
                    index = len(queue) - 1
                else:
                    index = index - 1
            else:
                queue.pop(0)
                cnt = cnt + 1
                if index == 0:
                    print(cnt)
                    break
                else:
                    index = index - 1


printer()