import java.util.*;
import java.io.*;

public class P5972_택배_배송 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, v));
            graph[e].add(new Edge(s, v));
        }
        System.out.print(dijkstra(graph));
    }
    public static int dijkstra(List<Edge>[] graph){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Edge(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            if (!visited[cur.vertex]){
                visited[cur.vertex] = true;
                List<Edge> nextList = graph[cur.vertex];

                for (Edge next : nextList){
                    if (distance[next.vertex] > distance[cur.vertex] + next.dist){
                        distance[next.vertex] = distance[cur.vertex] + next.dist;
                        pq.add(new Edge(next.vertex, distance[next.vertex]));
                    }
                }
            }
        }
        return distance[graph.length - 1];
    }
    static class Edge implements Comparable<Edge> {
        int vertex;
        int dist;

        public Edge(int vertex, int dist){
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o1){
            return this.dist - o1.dist;
        }
    }
}
