import java.util.Scanner;

public class P15652_N과M4 {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        dfs(1, 0);
        System.out.println(sb);
    }

    private static void dfs(int index, int depth) {
        if (depth == m){
            for (int item : arr){
                sb.append(item + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i <= n; i++){
            arr[depth] = i;
            dfs(i, depth+1);
        }
    }
}
