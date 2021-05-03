import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003_최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < n; i++){
            int item = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.getLast().value > item){
                deque.pollLast();
            }
            deque.addLast(new Node(i, item));
            if (deque.getFirst().index <= i - l){
                deque.pollFirst();
            }
            sb.append(deque.getFirst().value + " ");
        }
        System.out.println(sb.toString());
    }
}

class Node {
    int index, value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
