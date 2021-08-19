import java.util.*;
import java.io.*;

public class P1647_도시_분할_계획 {
    static int[] rank;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        rank = new int[N+1];
        parent = new int[N+1];
        for (int i = 1; i <= N; i++){
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            pq.add(new Node(s, e, dist));
        }
        int ans = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (find(node.s) != find(node.e)){
                union(node.s, node.e);
                ans += node.dist;
                cnt++;
                if (cnt == N - 2) break;
            }
        }
        System.out.print(ans);
    }
    public static class Node{
        int s;
        int e;
        int dist;

        public Node(int s, int e, int dist){
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
    }
    public static int find(int x){
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (rank[x] >= rank[y]){
            parent[y] = x;
            rank[x] += rank[y];
        }
        else {
            parent[x] = y;
            rank[y] += rank[x];
        }
    }
}
