from sys import stdin


def stack_seq():
    n = int(stdin.readline().rstrip())
    arr = []
    print_arr = []
    i = 1
    flag = True

    for _ in range(n):
        number = int(stdin.readline().rstrip())
        while (i <= number):
            arr.append(i)
            i = i + 1
            print_arr.append('+')
        if arr[-1] == number:
            arr.pop()
            print_arr.append('-')
        else:
            print('NO')
            flag = False
            break

    if flag:
        for p in print_arr:
            print(p)


stack_seq()