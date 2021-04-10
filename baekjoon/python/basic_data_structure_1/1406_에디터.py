import sys


class Node:
    def __init__(self, item, prev, next):
        self.item = item
        self.prev = prev
        self.next = next


class LinkedList:
    def __init__(self):
        self.head = Node(None, None, None)
        self.tail = Node(None, self.head, None)
        self.head.next = self.tail
        self.cursor = self.head

    def append(self, item):
        newNode = Node(item, self.cursor, self.cursor.next)
        orgNext = self.cursor.next
        self.cursor.next = newNode
        orgNext.prev = newNode
        self.cursor = newNode

    def delete(self):
        self.cursor.prev.next = self.cursor.next
        self.cursor.next.prev = self.cursor.prev
        self.cursor = self.cursor.prev

    def printList(self):
        pointer = self.head.next
        while(pointer.next is not None):
            print(pointer.item, end='')
            pointer = pointer.next


def editor():
    line = sys.stdin.readline().rstrip()
    n = int(sys.stdin.readline().rstrip())

    arr = LinkedList()

    for i in range(len(line)):
        arr.append(line[i])

    for i in range(n):
        cmdLine = sys.stdin.readline().rstrip().split(' ')
        cmd = cmdLine[0]

        if cmd == 'P':
            arr.append(cmdLine[1])
        elif cmd == 'L':
            if arr.cursor.prev is None:
                pass
            else:
                arr.cursor = arr.cursor.prev
        elif cmd == 'D':
            if arr.cursor.next is arr.tail:
                pass
            else:
                arr.cursor = arr.cursor.next
        elif cmd == 'B':
            if arr.cursor.prev is None:
                pass
            else:
                arr.delete()

    arr.printList()

editor()