import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p15649 {
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

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == m){
            for(int k : arr){
                System.out.print(k + " ");
            }
            System.out.println("");
            return;
        }
        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                visited[i] = true;
                arr.add(i);
                dfs(depth + 1);
                arr.remove(arr.size()-1);
                visited[i] = false;
            }
        }
    }
}
