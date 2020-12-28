import sys
import collections


def dequeue():
    N = int(sys.stdin.readline().rstrip())
    arr = collections.deque()

    for i in range(0, N):
        cmdLine = sys.stdin.readline().rstrip().split(' ')
        cmd = cmdLine[0]
        if cmd == 'push_front':
            arr.appendleft(int(cmdLine[1]))
        elif cmd == 'push_back':
            arr.append(int(cmdLine[1]))
        elif cmd == 'pop_front':
            if arr:
                print(arr.popleft())
            else:
                print(-1)
        elif cmd == 'pop_back':
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
        elif cmd == 'front':
            if arr:
                print(arr[0])
            else:
                print(-1)
        elif cmd == 'back':
            if arr:
                print(arr[-1])
            else:
                print(-1)
        else:
            print('error')


dequeue()
