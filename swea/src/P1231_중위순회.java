import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1231_중위순회 {
    static class Node {
        char val;
        int left;
        int right;

        public Node(char val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static StringBuilder sb;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = 10;
        for (int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            nodes = new Node[N+1];

            for (int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());

                char val = st.nextToken().charAt(0);
                int left;
                try {
                    left = Integer.parseInt(st.nextToken());
                } catch (Exception e){
                    left = 0;
                }
                int right;
                try {
                    right = Integer.parseInt(st.nextToken());
                } catch (Exception e){
                    right = 0;
                }

                nodes[index] = new Node(val, left, right);
            }
            sb.append("#").append(t).append(" ");
            inorder(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void inorder(int root){
        if (root == 0) return;
        Node node = nodes[root];
        inorder(node.left);
        sb.append(node.val);
        inorder(node.right);
    }
}
