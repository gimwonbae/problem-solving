import java.util.*;
import java.io.*;

public class p1922 {
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Edge> graph = new ArrayList<>();

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            graph.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(graph);

        parent = new int[n+1];
        for (int i = 1; i <= n; i++){
            parent[i] = i;
        }
        int ans = 0;
        for (int i = 0; i < m; i++){
            Edge tmp = graph.get(i);
            int sParent = find(tmp.start);
            int eParent = find(tmp.end);
            if (sParent != eParent){
                ans += tmp.weight;
                union(sParent, eParent);
            }
        }
        System.out.println(ans);
    }
    static int find(int x){
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y) parent[x] = y;
    }
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
