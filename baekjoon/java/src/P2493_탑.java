import java.util.*;
import java.io.*;

public class P2493_탑 {
    static Stack<Node> stack = new Stack();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int x = Integer.parseInt(st.nextToken());
            sb.append(calc(new Node(x, i + 1)));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    static int calc(Node x){
        while(!stack.isEmpty()){
            Node front = stack.pop();
            if (front.value > x.value){
                stack.push(front);
                stack.push(x);
                return front.index;
            }
        }
        stack.push(x);
        return 0;
    }

    static class Node {
        int value;
        int index;
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
