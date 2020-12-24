import sys


def stack():
    N = int(sys.stdin.readline().rstrip())
    arr = []

    for i in range(0, N):
        cmdLine = sys.stdin.readline().rstrip().split(' ')
        cmd = cmdLine[0]
        if cmd == 'push':
            arr.append(int(cmdLine[1]))
        elif cmd == 'pop':
            if arr:
                print(arr.pop())
            else:
                print(-1)
        elif cmd == 'size':
            print(len(arr))
        elif cmd == 'empty':
            if arr:
                print(0)
            else:
                print(1)
        elif cmd == 'top':
            if arr:
                print(arr[-1])
            else:
                print(-1)
        else:
            print('error')


stack()