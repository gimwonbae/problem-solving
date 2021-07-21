class P12304_UserSolution {
    class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
        }
    }

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;
    private Node tail;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        nodeCnt = 0;
        node = new Node[MAX_NODE];
    }

    public void addNode2Head(int data) {
        Node newNode = getNode(data);
        Node next = head.next;

        head.next = newNode;
        newNode.prev = head;
        newNode.next = next;
        next.prev = newNode;
    }

    public void addNode2Tail(int data) {
        Node newNode = getNode(data);
        Node prev = tail.prev;

        tail.prev = newNode;
        newNode.next = tail;
        newNode.prev = prev;
        prev.next = newNode;
    }

    public void addNode2Num(int data, int num) {
        Node newNode = getNode(data);
        Node prev = head;
        for (int i = 0; i < num - 1; i++){
            prev = prev.next;
        }
        Node next = prev.next;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;
    }

    public int findNode(int data) {
        Node target = head;
        for (int i = 0; i < nodeCnt; i++){
            target = target.next;
            if (target.data == data) return i+1;
        }
        return -1;
    }

    public void removeNode(int data) {
        Node prev = head;
        for (int i = 0; i < nodeCnt; i++){
            if (prev.next.data == data) break;
            prev = prev.next;
        }
        if (prev.next.next == null) return;
        else{
            Node next = prev.next.next;
            prev.next = next;
            next.prev = prev;

            nodeCnt--;
        }
    }

    public int getList(int[] output) {
        Node target = head;
        for (int i = 0; i < nodeCnt; i++){
            target = target.next;
            output[i] = target.data;
        }
        return nodeCnt;
    }

    public int getReversedList(int[] output) {
        Node target = tail;
        for (int i = 0; i < nodeCnt; i++){
            target = target.prev;
            output[i] = target.data;
        }
        return nodeCnt;
    }
}