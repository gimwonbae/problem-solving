import java.util.ArrayList;
import java.util.Scanner;

public class P2606_바이러스 {
    public static boolean[] visited;
    public static ArrayList<Integer>[] arr;
    public static int cnt = 0;

    public static void dfs(int x){
        if (visited[x]){
            return;
        }
        visited[x] = true;
        cnt++;
        for (int i : arr[x]){
            if (!visited[i]){
                dfs(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

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
        visited = new boolean[n+1];
        dfs(1);
        System.out.println(cnt-1);
    }
}