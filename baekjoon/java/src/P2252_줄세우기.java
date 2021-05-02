import java.util.*;

public class P2252_줄세우기 {
    static List<Integer>[] graph;
    static int[] indegree;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        indegree = new int[n+1];

        graph = new List[n+1];
        for (int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            indegree[y]++;
        }
        tsort();
    }
    static void tsort(){
        Queue<Integer> q = new LinkedList();
        for (int i = 1; i < n+1; i++) {
            if (indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for (int v : graph[x]) {
                indegree[v]--;
                if (indegree[v] == 0){
                    q.add(v);
                }
            }
        }
    }
}
