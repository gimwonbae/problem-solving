from sys import stdin


def ac():
    t = int(stdin.readline().rstrip())
    for _ in range(t):
        p = stdin.readline().rstrip()
        n = int(stdin.readline().rstrip())
        x_arr = list(filter(None, stdin.readline().strip('[]\n').split(',')))

        token = False
        err = False

        for cmd in p:
            if cmd == 'R':
                token = not token
            elif cmd == 'D':
                if not x_arr:
                    err = True
                    print('error')
                    break
                if token:
                    x_arr.pop()
                else:
                    x_arr.pop(0)
        if err:
            continue
        if token:
            x_arr.reverse()
        print(f'[{",".join(x_arr)}]')


ac()