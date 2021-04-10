import bisect


def sort_n():
    n = int(input())
    arr = list()
    
    for _ in range(n):
        nitem = int(input())
        nindex = bisect.bisect(arr, nitem)
        arr.insert(nindex, nitem)

    for i in range(n):
        print(arr[i])


sort_n()
