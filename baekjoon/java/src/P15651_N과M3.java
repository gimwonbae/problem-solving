import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P15651_N과M3 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == m){
            for (int item : arr){
                sb.append(item + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++){
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}
