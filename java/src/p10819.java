import java.util.Scanner;

public class p10819 {
    static int[] map;
    static int[] ans;
    static boolean[] visited;
    static int n;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n];
        ans = new int[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextInt();
        }
        dfs(0);
        System.out.print(max);
    }

    private static void dfs(int depth) {
        if (depth == n){
            calc();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                visited[i] = true;
                ans[depth] = map[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void calc() {
        int sum = 0;
        for (int i = 0; i <= n-2; i++){
            sum += Math.abs(ans[i] - ans[i+1]);
        }
        if (sum > max) max = sum;
    }
}
