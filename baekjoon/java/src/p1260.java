import java.util.*;

public class p1260 {
    public static ArrayList<Integer>[] arr;
    public static int n;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }
        for (int i = 1; i <= n; i++){
            Collections.sort(arr[i]);
        }
        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);
        System.out.println();
        sc.close();
    }

    public static void dfs(int v){
        if (visited[v]){
            return;
        }
        visited[v] = true;
        System.out.print(v + " ");
        for (int i : arr[v]){
            if (!visited[i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            v = queue.poll();
            System.out.print(v + " ");
            for (int i : arr[v]){
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
