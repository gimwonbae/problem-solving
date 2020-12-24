from sys import stdin

def yosef():
    n, k = map(int, stdin.readline().rstrip().split(' '))

    output = []
    arr = list(range(1, n+1))
    target = 0

    while arr:
        target = (target + (k-1))%len(arr)
        output.append(str(arr.pop(target)))

    print(f'<{", ".join(output)}>')


yosef()