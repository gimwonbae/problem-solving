import java.util.*;

public class P15650_N과M2 {
    static int n;
    static int m;
    static List<Integer> arr;
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new ArrayList<>();
        visited = new boolean[n+1];

        dfs(0,0);
    }

    private static void dfs(int k, int depth) {
        if (depth == m){
            for (int item : arr){
                System.out.print(item + " ");
            }
            System.out.println();
            return;
        }
        for (int i = k + 1; i <= n; i++){
            if (!visited[i]){
                visited[i] = true;
                arr.add(i);
                dfs(i, depth + 1);
                arr.remove(arr.size()-1);
                visited[i] = false;
            }
        }
    }
}
