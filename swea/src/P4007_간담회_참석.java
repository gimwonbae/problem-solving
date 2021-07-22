import java.util.*;
import java.io.*;

public class P4007_간담회_참석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Edge>> graph1;
        List<List<Edge>> graph2;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++){
            graph1 = new ArrayList<>();
            graph2 = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= N; i++){
                graph1.add(new ArrayList<>());
                graph2.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                graph1.get(start).add(new Edge(end, dist));
                graph2.get(end).add(new Edge(start, dist));
            }
            int[] distList1 = new int[N+1];
            int[] distList2 = new int[N+1];
            dijkstra(graph1, distList1, V);
            dijkstra(graph2, distList2, V);

            sb.append("#").append(t).append(" ").append(getMax(distList1, distList2)).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(List<List<Edge>> graph, int[] distList, int start){
        boolean[] visited = new boolean[distList.length];
        Arrays.fill(distList, Integer.MAX_VALUE);
        distList[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            int current = pq.poll().vertex;

            if(visited[current]) continue;
            visited[current] = true;

            for (Edge next: graph.get(current)) {
                if (distList[next.vertex] > distList[current] + next.dist) {
                    distList[next.vertex] = distList[current] + next.dist;
                    pq.add(new Edge(next.vertex, distList[next.vertex]));
                }
            }
        }
    }
    public static int getMax(int[] distList1, int[] distList2){
        int max = 0;
        for (int i = 0; i < distList1.length; i++){
            max = Math.max(max, distList1[i] + distList2[i]);
        }
        return max;
    }
}
class Edge implements Comparable<Edge>{
    int vertex;
    int dist;

    public Edge(int vertex, int dist){
        this.vertex = vertex;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge o) {
        return this.dist - o.dist;
    }
}
