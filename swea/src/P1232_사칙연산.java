import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1232_사칙연산 {
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            nodes = new Node[N+1];
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                String val = st.nextToken();
                int left;
                int right;
                if (st.hasMoreTokens()){
                    left = Integer.parseInt(st.nextToken());
                    right = Integer.parseInt(st.nextToken());
                }
                else {
                    left = 0;
                    right = 0;
                }
                nodes[index] = new Node(val, left, right);
            }
            sb.append((int)sol(1)).append("\n");
        }
        System.out.print(sb);
    }
    public static double sol(int index){
        Node node = nodes[index];
        if (node.val.equals("*")) return sol(node.left) * sol(node.right);
        else if (node.val.equals("/")) return sol(node.left) / sol(node.right);
        else if (node.val.equals("+")) return sol(node.left) + sol(node.right);
        else if (node.val.equals("-")) return sol(node.left) - sol(node.right);
        else return Double.parseDouble(node.val);
    }
    static class Node {
        String val;
        int left;
        int right;

        public Node(String val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
