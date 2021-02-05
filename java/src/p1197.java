import java.util.*;
import java.io.*;

public class p1197 {
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Edge> graph = new ArrayList<>();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        for (int i = 1; i <= v; i++){
            parent[i] = i;
        }
        for (int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            graph.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(graph);
        int ans = 0;
        for (int i = 0; i < e; i++){
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
        if (x != y){
            parent[x] = y;
        }
    }
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
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
