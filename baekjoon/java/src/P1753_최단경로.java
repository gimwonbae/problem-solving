import java.util.*;
import java.io.*;

public class P1753_최단경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, dist));
        }
        int[] dist = new int[V+1];
        dijkstra(dist, graph, start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++){
            int ans = dist[i];
            if (ans == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    public static void dijkstra(int[] dist, List<Edge>[] graph, int start){
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[dist.length];
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            int current = pq.poll().vertex;

            if (visited[current]) continue;
            visited[current] = true;

            for (Edge next : graph[current]){
                if (dist[next.vertex] > dist[current] + next.dist){
                    dist[next.vertex] = dist[current] + next.dist;
                    pq.add(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int dist;

    public Edge(int vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge o) {
        return this.dist - o.dist;
    }
}
