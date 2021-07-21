public class P12303_Single_Linked_List {
    class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = new Node(0);
        node = new Node[MAX_NODE];
        nodeCnt = 0;
    }

    public void addNode2Head(int data) {
        Node newNode = getNode(data);
        if (head.next == null) head.next = newNode;
        else {
            Node next = head.next;
            head.next = newNode;
            newNode.next = next;
        }
    }

    public void addNode2Tail(int data) {
        Node newNode = getNode(data);
        Node prev = head;
        while (prev.next != null){
            prev = prev.next;
        }
        prev.next = newNode;
    }

    public void addNode2Num(int data, int num) {
        Node newNode = getNode(data);
        Node prev = head;
        for (int i = 0; i < num - 1; i++){
            prev = prev.next;
        }
        if (prev.next == null) prev.next = newNode;
        else {
            Node next = prev.next;
            prev.next = newNode;
            newNode.next = next;
        }
    }

    public void removeNode(int data) {
        Node prev = head;
        for (int i = 0; i < nodeCnt; i++){
            if (prev.next.data == data) break;
            prev = prev.next;
        }
        if (prev.next == null) return;
        if (prev.next.next == null) prev.next = null;
        else {
            prev.next = prev.next.next;
        }
        nodeCnt--;
    }

    public int getList(int[] output) {
        Node target = head;
        for (int i = 0; i < nodeCnt; i++){
            target = target.next;
            output[i] = target.data;
        }
        return nodeCnt;
    }
}